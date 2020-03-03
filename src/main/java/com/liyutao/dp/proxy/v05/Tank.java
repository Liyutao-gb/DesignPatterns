package com.liyutao.dp.proxy.v05;


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
        new TankTimeProxy().move();
    }
}

// 帮忙多做了一些事儿，但都做的是同一件事,实现的是同一个接口
class TankTimeProxy implements Movable {

    Tank tank;

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

// 日志代理，打印日志
class TankLogProxy implements Movable {

    Tank tank;

    @Override
    public void move() {
        System.out.println("start moving...");
        tank.move();
        System.out.println("stopped!");
    }
}

interface Movable {
    void move();
}