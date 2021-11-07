package com.demo.collection;

import java.util.*;

/**
 * @author fuguo
 * @date 2021/11/04 3:25 下午
 */
public class ListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        for(int num : linkedList){
            System.out.println(num);
        }
        linkedList.add(1,20);
        for(int num : linkedList){
            System.out.println(num);
        }
        String [] array = {"ds","sd"};


    }
}
