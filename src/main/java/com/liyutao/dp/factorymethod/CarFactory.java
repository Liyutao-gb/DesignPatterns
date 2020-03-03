package com.liyutao.dp.factorymethod;

/**
 * @auther lytstart
 * @create 2020-01-13-18:13
 */
public class CarFactory {
    public Moveable create() {   // Moveable更严谨
        System.out.println("a car created!");
        return new Car();
    }
}
