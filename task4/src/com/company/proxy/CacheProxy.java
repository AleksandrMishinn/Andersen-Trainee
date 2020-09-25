package com.company.proxy;

import com.company.proxy.annotations.CachedMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheProxy implements InvocationHandler {

    private final Map<String, Method> methods = new HashMap<>();
    private final Map<MethodPair, Object> cacheStore = new ConcurrentHashMap<>();
    private Object target;

    public CacheProxy(Object target) {
        this.target = target;

        for (Method method : target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }

    public Object init() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return cache(method, args);
    }

    private Object cache(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        String methodsName = method.getName();
        Method currentMethod = methods.get(methodsName);

        if (!currentMethod.isAnnotationPresent(CachedMethod.class)) {
            return currentMethod.invoke(target, args);
        }

        MethodPair pair = new MethodPair(methodsName, args);

        cacheStore.computeIfAbsent(pair, value -> {
            try {
                return currentMethod.invoke(target, args);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        });

        return cacheStore.get(pair);
    }
}
