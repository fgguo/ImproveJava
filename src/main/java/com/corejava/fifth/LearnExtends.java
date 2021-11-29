package com.corejava.fifth;

import java.util.Random;

/**
 * @author fuguo
 * @date 2021/10/28 3:04 下午
 */
class Employee{
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;
    //静态初始块
    static
    {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
        System.out.println(nextId);
    }
    //对象的实例字段初始化快
    {
        id = nextId;
        nextId++;
    }
    // 三个构造函数
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    public Employee(double salary){
        //调用其他构造器：Employee(String,double)
        this("Employee #" + nextId, salary);
    }
    //默认构造器
    public Employee(){
        /*
        默认构造函数的初始化：
            name初始化为""
            salary初始化为0
            id在实例字段的初始块中初始化
         */
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
class Manager extends Employee{
    private double bonus;
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public Manager(String name, double salary){
        super(name,salary);//这里的super指的是调用和参数匹配的父类构造器
        this.bonus = 0;
    }
    //重写(覆盖)父类的getSalary
    @Override
    public double getSalary(){
        //return bonus + salary; 这样不行，因为salary是Employee类私有，不能被其他类访问
        //return getSalary() + bonus;也不行，这样相当于无限次调用本类的getSalary
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
public class LearnExtends {
    public static void main(String[] args) {
        Employee employee = new Employee("付国",25000);
        System.out.println(employee.toString());
        Employee employee1 = new Employee();
        System.out.println(employee1.toString());
        Manager manager = new Manager("郑婷月",30000);
        manager.setBonus(10000);
        System.out.println(manager.getSalary());
    }

}
