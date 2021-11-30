package com.demo.proxy;

import main.java.com.demo.proxy.RealProvider;

/**
 * @author fuguo
 * @date 2021/10/30 10:54 下午
 */

//现在有个需求，需要对 getData 方法做限流，指定用静态代理的方式。
public class StaticProxy implements com.demo.proxy.IProvider {
    //持有被代理的类的引用(这里是指RealProvider)
    private com.demo.proxy.IProvider iProvider;
    public StaticProxy(com.demo.proxy.IProvider iProvider){
        this.iProvider = iProvider;
    }

    @Override
    public Object getData(String json) {
        //在这里重写，实现代理的需求
        System.out.println("静态代理类实现了代理功能");
        Object object = iProvider.getData(json);//调用被代理类方法
        return object;
    }

    public static void main(String[] args) {
        StaticProxy staticProx = new StaticProxy(new RealProvider());
        staticProx.getData("测试");
    }
}
