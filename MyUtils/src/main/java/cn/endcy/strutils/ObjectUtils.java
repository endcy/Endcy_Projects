package cn.endcy.strutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxx on 2017/6/29.
 */
public class ObjectUtils {

    /**
     * 将不知类型的vo对象转换成Map形式
     *
     * @param vo
     * @return
     */
    public static Map<String, Object> vo2Map(Object vo) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        Class clazz = vo.getClass();
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            String methodName = m.getName();
            if (methodName.startsWith("get") && !"getClass".equals(methodName)) {
                String fieldName = methodName.substring(3).toLowerCase();
                try {
                    retMap.put(fieldName, m.invoke(vo));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return retMap;
    }

    /**
     * 从Url中的参数中解析数据
     *
     * @param urlData
     * @return
     */
    public static Map<String, String> parseRecParam(String urlData) {
        Map<String, String> retMap = new HashMap<String, String>();
        String paramsStr = urlData;
        String[] keyAndValues = paramsStr.split("&");
        for (String kv : keyAndValues) {
            int equalFlagIdx = kv.indexOf("=");
            if (equalFlagIdx == -1) continue;
            String paramName = kv.substring(0, equalFlagIdx);
            String paramValue = kv.substring(equalFlagIdx + 1, kv.length());
            retMap.put(paramName, paramValue);
        }
        return retMap;
    }

}
