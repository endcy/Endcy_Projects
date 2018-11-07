package cn.endcy.netutils;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.impl.cookie.BestMatchSpec;
import org.apache.http.message.BasicNameValuePair;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

/**
 * Created by cxx on 2017/6/23.
 */
class AnyTrustStrategy implements TrustStrategy {

    @Override
    public boolean isTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
        return true;
    }

}

/**
 * <p>
 * HTTP Client工具类
 * </p>
 *
 * @author PengJian
 * @version 1.0.0 2015年9月5日
 */
public class HttpClientUtil {

//    private static final Log log = LogFactory.getLog(HttpClientUtil.class);

    /**
     * 最大连接数
     */
    public static int MAX_CONNECTIONS = 400;
    /**
     * 获取连接的最大等待时间
     */
    public static int WAIT_TIMEOUT = 30 * 1000;
    /**
     * 每个路由最大连接数
     */
    public static int MAX_ROUTE_CONNECTIONS = 200;
    /**
     * 连接超时时间
     */
    public static int CONNECT_TIMEOUT = 3 * 1001;
    /**
     * 读取超时时间
     */
    public static int READ_TIMEOUT = 3 * 1002;
    /**
     * 读取缓冲区大小
     */
    private static int bufferSize = 1024;

    //private static volatile HttpClientUtil instance;

    private ConnectionConfig connConfig;

    private SocketConfig socketConfig;

    private ConnectionSocketFactory plainSF;

    private KeyStore trustStore;

    private SSLContext sslContext;

    private LayeredConnectionSocketFactory sslSF;

    private Registry<ConnectionSocketFactory> registry;

    private PoolingHttpClientConnectionManager connManager;

    private volatile HttpClient client;

    private volatile BasicCookieStore cookieStore;

    public static String defaultEncoding = "utf-8";

    /**
     * @return the mAX_CONNECTIONS
     */
    public static int getMaxConnections() {
        return MAX_CONNECTIONS;
    }

    /**
     * @param mAX_CONNECTIONS the mAX_CONNECTIONS to set
     */
    public static void setMaxConnections(int mAX_CONNECTIONS) {
        MAX_CONNECTIONS = mAX_CONNECTIONS;
    }

    /**
     * @return the wAIT_TIMEOUT
     */
    public static int getWaitTimeout() {
        return WAIT_TIMEOUT;
    }

    /**
     * @param wAIT_TIMEOUT the wAIT_TIMEOUT to set
     */
    public static void setWaitTimeout(int wAIT_TIMEOUT) {
        WAIT_TIMEOUT = wAIT_TIMEOUT;
    }

    /**
     * @return the mAX_ROUTE_CONNECTIONS
     */
    public static int getMaxRouteConnections() {
        return MAX_ROUTE_CONNECTIONS;
    }

    /**
     * @param mAX_ROUTE_CONNECTIONS the mAX_ROUTE_CONNECTIONS to set
     */
    public static void setMaxRouteConnections(int mAX_ROUTE_CONNECTIONS) {
        MAX_ROUTE_CONNECTIONS = mAX_ROUTE_CONNECTIONS;
    }

    /**
     * @return the cONNECT_TIMEOUT
     */
    public static int getConnectTimeout() {
        return CONNECT_TIMEOUT;
    }

    /**
     * @param cONNECT_TIMEOUT the cONNECT_TIMEOUT to set
     */
    public static void setConnectTimeout(int cONNECT_TIMEOUT) {
        CONNECT_TIMEOUT = cONNECT_TIMEOUT;
    }

    /**
     * @return the rEAD_TIMEOUT
     */
    public static int getReadTimeout() {
        return READ_TIMEOUT;
    }

    /**
     * @param rEAD_TIMEOUT the rEAD_TIMEOUT to set
     */
    public static void setReadTimeout(int rEAD_TIMEOUT) {
        READ_TIMEOUT = rEAD_TIMEOUT;
    }

    private static List<NameValuePair> paramsConverter(
            Map<String, String> params) {
        List<NameValuePair> nvps = new LinkedList<NameValuePair>();
        Set<Entry<String, String>> paramsSet = params.entrySet();
        for (Entry<String, String> paramEntry : paramsSet) {
            nvps.add(new BasicNameValuePair(paramEntry.getKey(), paramEntry
                    .getValue()));
        }
        return nvps;
    }

    public static String readStream(InputStream in, String encoding) {
        if (in == null) {
            return null;
        }
        try {
            InputStreamReader inReader = null;
            if (encoding == null) {
                inReader = new InputStreamReader(in, defaultEncoding);
            } else {
                inReader = new InputStreamReader(in, encoding);
            }
            char[] buffer = new char[bufferSize];
            int readLen = 0;
            StringBuffer sb = new StringBuffer();
            while ((readLen = inReader.read(buffer)) != -1) {
                sb.append(buffer, 0, readLen);
            }
            inReader.close();
            return sb.toString();
        } catch (IOException e) {
//            log.error("读取返回内容出错", e);
        }
        return null;
    }

    public HttpClientUtil() {

    }

    public void paramConfig() {
        // 设置连接参数
        connConfig = ConnectionConfig.custom()
                .setCharset(Charset.forName(defaultEncoding)).build();
        socketConfig = SocketConfig.custom().setSoTimeout(READ_TIMEOUT).build();
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder
                .<ConnectionSocketFactory>create();
        plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        // 指定信任密钥存储对象和连接套接字工厂
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            sslContext = SSLContexts.custom().useTLS()
                    .loadTrustMaterial(trustStore, new AnyTrustStrategy())
                    .build();
            sslSF = new SSLConnectionSocketFactory(sslContext,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSF);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        registry = registryBuilder.build();

        // 设置连接管理器
        connManager = new PoolingHttpClientConnectionManager(registry);
        connManager.setDefaultConnectionConfig(connConfig);
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setMaxTotal(MAX_CONNECTIONS);
        connManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);

        // 指定cookie存储对象
        cookieStore = new BasicCookieStore();
        // 构建客户端
        // TODO：暂时只支持单例
        client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore)
                .setConnectionManager(connManager).build();
    }

    public HttpClientUtil(int maxConnections,
                          int maxRouteConnections,
                          int waitTimeout,
                          int connTimeout,
                          int readTimeout,
                          int buffersize) {

        MAX_CONNECTIONS = maxConnections;
        WAIT_TIMEOUT = waitTimeout;
        MAX_ROUTE_CONNECTIONS = maxRouteConnections;
        CONNECT_TIMEOUT = connTimeout;
        READ_TIMEOUT = readTimeout;
        bufferSize = buffersize;

        // 设置连接参数
        connConfig = ConnectionConfig.custom()
                .setCharset(Charset.forName(defaultEncoding)).build();
        socketConfig = SocketConfig.custom().setSoTimeout(READ_TIMEOUT).build();
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder
                .<ConnectionSocketFactory>create();
        plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        // 指定信任密钥存储对象和连接套接字工厂
        try {
            trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            sslContext = SSLContexts.custom().useTLS()
                    .loadTrustMaterial(trustStore, new AnyTrustStrategy())
                    .build();
            sslSF = new SSLConnectionSocketFactory(sslContext,
                    SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            registryBuilder.register("https", sslSF);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        registry = registryBuilder.build();

        // 设置连接管理器
        connManager = new PoolingHttpClientConnectionManager(registry);
        connManager.setDefaultConnectionConfig(connConfig);
        connManager.setDefaultSocketConfig(socketConfig);
        connManager.setMaxTotal(MAX_CONNECTIONS);
        connManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);

        // 指定cookie存储对象
        cookieStore = new BasicCookieStore();
        // 构建客户端
        // TODO：暂时只支持单例
        client = HttpClientBuilder.create().setDefaultCookieStore(cookieStore)
                .setConnectionManager(connManager).build();
    }

/*    public static HttpClientUtil getInstance()
    {
        synchronized (HttpClientUtil.class)
        {
            if (HttpClientUtil.instance == null)
            {
                instance = new HttpClientUtil();
            }
            return instance;
        }
    }*/

    /**
     * 构建公用RequestConfig
     *
     * @return
     */
    public static RequestConfig buildRequestConfig() {
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(READ_TIMEOUT)
                .setConnectTimeout(CONNECT_TIMEOUT).build();
        return requestConfig;
    }

    public InputStream doGet(String url) throws URISyntaxException,
            ClientProtocolException, IOException {
        HttpResponse response = this.doGet(url, null);
        return response != null ? response.getEntity().getContent() : null;
    }

    public String doGetForString(String url) throws URISyntaxException,
            ClientProtocolException, IOException {
        return HttpClientUtil.readStream(this.doGet(url), null);
    }

    public InputStream doGetForStream(String url,
                                      Map<String, String> queryParams) throws URISyntaxException,
            ClientProtocolException, IOException {
        HttpResponse response = this.doGet(url, queryParams);
        return response != null ? response.getEntity().getContent() : null;
    }

    public String doGetForString(String url, Map<String, String> queryParams)
            throws URISyntaxException, ClientProtocolException, IOException {
        return HttpClientUtil
                .readStream(this.doGetForStream(url, queryParams), null);
    }

    /**
     * 基本的Get请求
     *
     * @param url         请求url
     * @param queryParams 请求头的查询参数
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public HttpResponse doGet(String url, Map<String, String> queryParams)
            throws URISyntaxException, ClientProtocolException, IOException {
        HttpGet gm = new HttpGet();

        // 超时设置
        gm.setConfig(buildRequestConfig());

        URIBuilder builder = new URIBuilder(url);
        // 填入查询参数
        if (queryParams != null && !queryParams.isEmpty()) {
            builder.setParameters(HttpClientUtil.paramsConverter(queryParams));
        }
        gm.setURI(builder.build());
        return client.execute(gm);
    }

    public InputStream doPostForStream(String url,
                                       Map<String, String> queryParams) throws URISyntaxException,
            ClientProtocolException, IOException {
        HttpResponse response = this.doPost(url, queryParams, null);
        return response != null ? response.getEntity().getContent() : null;
    }

    public String doPostForString(String url, Map<String, String> queryParams)
            throws URISyntaxException, ClientProtocolException, IOException {
        return HttpClientUtil.readStream(this.doPostForStream(url, queryParams),
                null);
    }

    public InputStream doPostForStream(String url,
                                       Map<String, String> queryParams, Map<String, String> formParams)
            throws URISyntaxException, ClientProtocolException, IOException {
        HttpResponse response = this.doPost(url, queryParams, formParams);
        return response != null ? response.getEntity().getContent() : null;
    }

    public String doPostRetString(String url, Map<String, String> queryParams,
                                  Map<String, String> formParams) throws URISyntaxException,
            ClientProtocolException, IOException {
        return HttpClientUtil.readStream(
                this.doPostForStream(url, queryParams, formParams), null);
    }

    /**
     * 基本的Post请求
     *
     * @param url         请求url
     * @param queryParams 请求头的查询参数
     * @param formParams  post表单的参数
     * @return
     * @throws URISyntaxException
     * @throws IOException
     * @throws ClientProtocolException
     */
    public HttpResponse doPost(String url, Map<String, String> queryParams,
                               Map<String, String> formParams) throws URISyntaxException,
            ClientProtocolException, IOException {
        HttpPost pm = new HttpPost();

        // 超时设置
        pm.setConfig(buildRequestConfig());

        URIBuilder builder = new URIBuilder(url);
        // 填入查询参数
        if (queryParams != null && !queryParams.isEmpty()) {
            builder.setParameters(HttpClientUtil.paramsConverter(queryParams));
        }
        pm.setURI(builder.build());
        // 填入表单参数
        if (formParams != null && !formParams.isEmpty()) {
            pm.setEntity(new UrlEncodedFormEntity(HttpClientUtil
                    .paramsConverter(formParams)));
        }
        return client.execute(pm);
    }

    public String doPostForXmlString(String url, String content)
            throws URISyntaxException, ClientProtocolException, IOException {
        return HttpClientUtil.readStream(this.doPostForXmlStream(url, content),
                null);
    }

    public InputStream doPostForXmlStream(String url, String content)
            throws URISyntaxException, ClientProtocolException, IOException {
        HttpResponse response = this.doPostXml(url, content);
        return response != null ? response.getEntity().getContent() : null;
    }

    public String doPostRetXmlString(String url, String content) throws URISyntaxException,
            ClientProtocolException, IOException {
        return HttpClientUtil.readStream(this.doPostForXmlStream(url, content), null);
    }

    public HttpResponse doPostXml(String url, String content)
            throws URISyntaxException, ClientProtocolException, IOException {
        HttpPost pm = new HttpPost();

        URIBuilder builder = new URIBuilder(url);
        pm.setURI(builder.build());

        // 超时设置
        pm.setConfig(buildRequestConfig());
        // 设置发送头
        pm.addHeader("Content-Type", "text/xml; charset=UTF-8");

        // 填入发送串
        StringEntity strEntity = new StringEntity(content, "UTF-8");
        pm.setEntity(strEntity);

        return client.execute(pm);
    }

    /**
     * 多块Post请求
     *
     * @param url         请求url
     * @param queryParams 请求头的查询参数
     * @param formParts   post表单的参数,支持字符串-文件(FilePart)和字符串-字符串(StringPart)形式的参数
     * @return
     * @throws URISyntaxException
     * @throws ClientProtocolException
     * @throws HttpException
     * @throws IOException
     */
    public HttpResponse multipartPost(String url,
                                      Map<String, String> queryParams, List<FormBodyPart> formParts)
            throws URISyntaxException, ClientProtocolException, IOException {
        HttpPost pm = new HttpPost();
        URIBuilder builder = new URIBuilder(url);
        // 填入查询参数
        if (queryParams != null && !queryParams.isEmpty()) {
            builder.setParameters(HttpClientUtil.paramsConverter(queryParams));
        }
        pm.setURI(builder.build());
        // 填入表单参数
        if (formParts != null && !formParts.isEmpty()) {
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder
                    .create();
            entityBuilder = entityBuilder
                    .setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            for (FormBodyPart formPart : formParts) {
                entityBuilder = entityBuilder.addPart(formPart.getName(),
                        formPart.getBody());
            }
            pm.setEntity(entityBuilder.build());
        }
        return client.execute(pm);
    }

    /**
     * 获取当前Http客户端状态中的Cookie
     *
     * @param domain    作用域
     * @param port      端口 传null 默认80
     * @param path      Cookie路径 传null 默认"/"
     * @param useSecure Cookie是否采用安全机制 传null 默认false
     * @return
     */
    public Map<String, Cookie> getCookie(String domain, Integer port,
                                         String path, Boolean useSecure) {
        if (domain == null) {
            return null;
        }
        if (port == null) {
            port = 80;
        }
        if (path == null) {
            path = "/";
        }
        if (useSecure == null) {
            useSecure = false;
        }
        List<Cookie> cookies = cookieStore.getCookies();
        if (cookies == null || cookies.isEmpty()) {
            return null;
        }

        CookieOrigin origin = new CookieOrigin(domain, port, path, useSecure);
        BestMatchSpec cookieSpec = new BestMatchSpec();
        Map<String, Cookie> retVal = new HashMap<String, Cookie>();
        for (Cookie cookie : cookies) {
            if (cookieSpec.match(cookie, origin)) {
                retVal.put(cookie.getName(), cookie);
            }
        }
        return retVal;
    }

    /**
     * 批量设置Cookie
     *
     * @param cookies   cookie键值对图
     * @param domain    作用域 不可为空
     * @param path      路径 传null默认为"/"
     * @param useSecure 是否使用安全机制 传null 默认为false
     * @return 是否成功设置cookie
     */
    public boolean setCookie(Map<String, String> cookies, String domain,
                             String path, Boolean useSecure) {
        synchronized (cookieStore) {
            if (domain == null) {
                return false;
            }
            if (path == null) {
                path = "/";
            }
            if (useSecure == null) {
                useSecure = false;
            }
            if (cookies == null || cookies.isEmpty()) {
                return true;
            }
            Set<Entry<String, String>> set = cookies.entrySet();
            String key = null;
            String value = null;
            for (Entry<String, String> entry : set) {
                key = entry.getKey();
                if (key == null || key.isEmpty() || value == null
                        || value.isEmpty()) {
                    throw new IllegalArgumentException(
                            "cookies key and value both can not be empty");
                }
                BasicClientCookie cookie = new BasicClientCookie(key, value);
                cookie.setDomain(domain);
                cookie.setPath(path);
                cookie.setSecure(useSecure);
                cookieStore.addCookie(cookie);
            }
            return true;
        }
    }

    /**
     * 设置单个Cookie
     *
     * @param key       Cookie键
     * @param value     Cookie值
     * @param domain    作用域 不可为空
     * @param path      路径 传null默认为"/"
     * @param useSecure 是否使用安全机制 传null 默认为false
     * @return 是否成功设置cookie
     */
    public boolean setCookie(String key, String value, String domain,
                             String path, Boolean useSecure) {
        Map<String, String> cookies = new HashMap<String, String>();
        cookies.put(key, value);
        return setCookie(cookies, domain, path, useSecure);
    }

}
