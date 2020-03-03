package com.liyutao.dp.proxy.v06;


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
//        Tank t = new Tank();
//        TankTimeProxy ttp = new TankTimeProxy(t);
//        TankLogProxy tlp = new TankLogProxy(ttp);
//        tlp.move();

        new TankLogProxy(
                new TankTimeProxy(
                        new Tank()
                )
        ).move();
    }
}

// 代理
class TankTimeProxy implements Movable {
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

// 被代理
class TankLogProxy implements Movable {
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        System.out.println("stopped!");
    }
}

interface Movable {
    void move();
}