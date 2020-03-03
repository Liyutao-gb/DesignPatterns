package com.liyutao.dp.proxy.v01;


import java.util.Random;

/**
 * @auther lytstart
 * @create 2020-02-26-21:18
 *
 * 问题：我想记录坦克移动时间。
 */
public class Tank implements Movable{

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
}

interface Movable {
    void move();
}