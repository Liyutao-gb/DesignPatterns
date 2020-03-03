package com.liyutao.dp.proxy.v08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @auther lytstart
 * @create 2020-02-26-21:18
 *
 * 问题：我想记录坦克移动时间。
 *      最简单的方法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？ benchmark
 *      用继承？
 * v04：使用代码。
 *      代理人帮忙多做一些事，但是都干的一样的事儿，所以都实现一个接口
 * v05：代理各种类型
 *      问题：如何实现代理的各种组合？继承？Docorator？
 * v06：代理的对象改成Movable类型-越来越像decorator了
 *      静态代理。
 * v07：如果有stop方法需要代理...
 *      如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型 Object
 *      （毕竟日志记录，时间计算是很多方法都需要的东西），这时该怎么办呢？
 * 分离代理行为与被代理对象。
 *      使用JDK的动态代理
 * v08：横切代码与业务逻辑代码分离 AOP
 *
 */
public class Tank implements Movable {

    /*
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {

        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        // reflection 通过二进制字节码分析类的属性和方法

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, // tank.class.getInsterfaces()
                new TimeProxy(tank)
        );

        m.move();
    }
}

class TimeProxy implements InvocationHandler {

    Movable m;

    public TimeProxy(Movable m) {
        this.m = m;
    }

    public void before() {
        System.out.println("method start..");
    }

    public void after() {
        System.out.println("method stop..");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(m, args);
        after();
        return o;
    }
}

interface Movable {
    void move();
}