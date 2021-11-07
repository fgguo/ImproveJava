package com.demo.collection;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author fuguo
 * @date 2021/11/04 9:52 上午
 */
public class IterationDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("fuguo");
        list.add("zhengtingyue");
        list.add("jingdong");

        System.out.println("使用迭代器遍历");

        Iterator<String> iterator = list.iterator(); //获取一个迭代器

        while (iterator.hasNext()){ //判断集合是否还有元素
            String element = iterator.next(); //获取下一个元素
            System.out.println(element);
        }

        System.out.println("使用for each循环 遍历");
        for(String element : list){
            System.out.println(element);
        }

        System.out.println("使用forEachRemaining遍历");
        iterator.forEachRemaining(e -> System.out.println(e));
        iterator = list.iterator();
        iterator.forEachRemaining(e -> System.out.println(e));
        //上面的第一次遍历结果是空的，因为在使用next遍历时，迭代器已经在末尾了。
        //重新获取一个迭代器的引用，再次遍历就正常了。
    }
}
