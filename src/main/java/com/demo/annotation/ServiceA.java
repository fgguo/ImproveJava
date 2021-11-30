package main.java.com.demo.annotation;

import lombok.Getter;

/**
 * @className: ServiceA
 * @description: ServiceA使用@SimpleInject表达对ServiceB的依赖。
 * @author: fuguo
 * @date: 2021/11/30
 **/
@Getter
public class ServiceA {
    @SimpleInject
    ServiceB b;
    public void callB(){
        b.action();
    }
}
