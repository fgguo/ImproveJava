package main.java.com.demo.lambok;

import com.sun.tools.corba.se.idl.constExpr.Or;
import lombok.*;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className: lambokDemo
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/11/29
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Order{
    private int id;
    private Date date;
    private int count;
    private double price;
    private double total;
}


public class lambokDemo {
    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.getTotal());
        System.out.println(order.toString());
    }
}
