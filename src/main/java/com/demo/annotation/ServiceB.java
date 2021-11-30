package main.java.com.demo.annotation;

/**
 * @className: ServiceB
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/30
 **/
@SimpleSingleton
public class ServiceB {
    public void action(){
        System.out.println("I'm B");
    }
}
