package com.liyutao.dp.factorymethod;

/**
 * @auther lytstart
 * @create 2020-02-17-22:49
 */
public class BroomFactory {
    public Moveable create() {   // Moveable更严谨
        System.out.println("a Broom created!");
        return new Broom();
    }
}
