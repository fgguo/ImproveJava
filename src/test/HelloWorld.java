package test;

/**
 * @author fuguo
 * @date 2021/10/25 7:36 下午
 */
public class HelloWorld {
    final String SMALL = "small";
    final String MEDIUM = "medium";
    enum Size {SMALL,MEDIUM};
    public static void main(String[] args) {
        Size s = Size.SMALL;
        System.out.println(s);

    }
}
