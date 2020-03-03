package com.liyutao.dp.proxy.v02;


import java.util.Random;

/**
 * @auther lytstart
 * @create 2020-02-26-21:18
 *
 * 问题：我想记录坦克移动时间。
 *      最简单的方法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？ benchmark
 */
public class Tank implements Movable {

    /*
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Movable {
    void move();
}