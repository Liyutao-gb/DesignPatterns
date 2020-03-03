package com.liyutao.dp.spring.v1;

import java.util.Random;

/**
 * @auther lytstart
 * @create 2020-02-27-12:32
 */
public class Tank {
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
