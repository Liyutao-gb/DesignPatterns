package com.liyutao.dp.factorymethod;

/**
 * @auther lytstart
 * @create 2020-01-13-17:44
 * 工厂系列：简单工厂、静态工厂、工厂方法、抽象工厂、Spring IOC(inverse of control)
 * 任何可以产生对象的方法或类，都可以称之为工厂
 * 单例也是一种工厂
 * 为什么有了new之后，还要有工厂？
 *      灵活控制生产控制
 *      权限、修饰、日志...
 * 用到了多态
 */
public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();
    }
}
