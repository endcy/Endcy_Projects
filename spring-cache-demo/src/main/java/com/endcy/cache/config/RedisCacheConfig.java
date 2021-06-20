package com.endcy.cache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class RedisCacheConfig {

    @Autowired
    ResourceLoader resourceLoader;

    @Bean
    @Primary
    public RedisCacheManager redisCacheManager(RedisTemplate<Object, Object> template, RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                // 60s缓存失效
                .entryTtl(Duration.ofSeconds(60L))
                // key的序列化方式
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(template.getStringSerializer()))
                // value的序列化方式
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(template.getValueSerializer()))
                // 不缓存null值
                .disableCachingNullValues();

        return RedisCacheManager.builder()
                .cacheWriter(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(config)
                .withInitialCacheConfigurations(getCacheConfigurations())
                .build();
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return RedisCacheManager.builder(redisConnectionFactory)
                //默认的缓存配置(没有配置键的key均使用此配置)
                .cacheDefaults(getDefaultCacheConfiguration())
                .withInitialCacheConfigurations(getCacheConfigurations())
                //在spring事务正常提交时才缓存数据
                .transactionAware()
                .build();
    }

    private Map<String, RedisCacheConfiguration> getCacheConfigurations() {
        Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        //缓存键,x秒后再次调用方法时需要重新缓存
        configurationMap.put("userCache", this.getDefaultCacheConfiguration(60L));
        return configurationMap;
    }

    /**
     * 获取redis的缓存配置(针对于键)
     */
    private RedisCacheConfiguration getDefaultCacheConfiguration(long seconds) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer
                = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(jackson2JsonRedisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));
        return redisCacheConfiguration;
    }

    /**
     * 获取Redis缓存配置,此处获取的为默认配置
     * 如对键值序列化方式,是否缓存null值,是否使用前缀等有特殊要求
     * 可另行调用 RedisCacheConfiguration 的构造方法
     */
    private RedisCacheConfiguration getDefaultCacheConfiguration() {
        // 注意此构造函数为 spring-data-redis-2.1.9 及以上拥有
        // 如没有则需要在值序列化器(valueSerializationPair)的构造中注入 ClassLoader 即可
        return RedisCacheConfiguration.defaultCacheConfig(resourceLoader.getClassLoader());
    }

}