package main.java.com.demo.annotation;

import java.net.ServerSocket;

/**
 * @className: ContainerDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/30
 **/
public class ContainerDemo {
    public static void userSimpleContainer(){
        ServiceA  a = SimpleContainer.getInstance(ServiceA.class);
        a.callB();

        ServiceB b = SimpleContainer.getInstance(ServiceB.class);
        if(b != a.getB()){
            System.out.println("SimpleContainer:different instances");
        }
    }

    public static void userSimpleContainer2(){
        ServiceA a = SimpleContainer.getInstance(ServiceA.class);
        a.callB();
        ServiceB b = SimpleContainer.getInstance(ServiceB.class);
        if(b != a.getB()){
            System.out.println("SimpleContainer:different instances");
        }
        else{
            System.out.println("SimpleContainer:same instances");
        }
    }
    public static void main(String[] args) {
        userSimpleContainer2();
    }
}
