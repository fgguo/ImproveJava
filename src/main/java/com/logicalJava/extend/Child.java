package main.java.com.logicalJava.extend;

/**
 * @className: Child
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/19
 **/
public class Child extends com.logicalJava.extend.Base {
    public static int s;
    private int a;
    static {
        System.out.println("子类静态代码块，s: " + s);
        s = 10;
    }
    {
        System.out.println("子类实例代码块，a: "+ a);
        a = 10;
    }
    public Child(){
        System.out.println("子类构造方法，a :" + a);
        a = 20;
    }
    protected void step(){
        System.out.println("Child s :" + s + " Child a: " + a);

    }

    public static void main(String[] args) {
        System.out.println("------new Child()-------");
        Child c = new Child();
        System.out.println("-------c.action-----");
        c.action();
        com.logicalJava.extend.Base b = c;
        System.out.println("-------b.action()--------");
        b.action();
        System.out.println("-------b.s: " + b.s);
        System.out.println("-------c.s: " + c.s);
    }
}
