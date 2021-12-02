package com.demo.proxy;

import main.java.com.demo.proxy.RealProvider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fuguo
 * @date 2021/10/30 11:03 下午
 */

//动态代理

public class DynamicProxy implements InvocationHandler {
    private Object target; //被代理的类


    public Object bind(Object target){
        this.target = target;
        //生成代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //实现代理的逻辑
        System.out.println("动态代理实现");
        //调用被代理类的实际方法
        Object object = method.invoke(target,args);
        return object;
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        com.demo.proxy.IProvider iProvider = (com.demo.proxy.IProvider) dynamicProxy.bind(new RealProvider());
        iProvider.getData("dynamic proxy");
        Class clazz;
        Class[] parameterTypes;

    }
}
