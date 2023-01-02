package com.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xsc
 * @time 2023/1/2 - 14:21
 */
public class ObjectToMap {
    public static Map<String,Object> ObjectToMap(Object o){
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Field declaredField : o.getClass().getDeclaredFields()) {
            String methodName = "get" + declaredField.getName().toUpperCase().charAt(0) + declaredField.getName().substring(1);
            try {
                hashMap.put(declaredField.getName(),o.getClass().getMethod(methodName).invoke(o));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return hashMap;
    }
}
