package test;

/**
 * @author fuguo
 * @date 2021/10/25 7:36 下午
 */
public class HelloWorld {
    final String SMALL = "small";
    final String MEDIUM = "medium";
    String name = "ds";
    enum Size {SMALL,MEDIUM};
    HelloWorld(String n){
        String name = n;
    }
    public static void main(String[] args) {
        Size s = Size.SMALL;
        System.out.println(s);
        HelloWorld helloWorld = new HelloWorld("mu");
        System.out.println(helloWorld.name);
    }
}
