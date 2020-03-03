package com.liyutao.dp.state.v2;

/**
 * @auther lytstart
 * @create 2020-02-29-16:40
 */
public class MM {
    String name;
    MMState state;

    public void smile() {
        state.smile();
    }

    public void cry() {
        state.cry();
    }

    public void say() {
        state.say();
    }
}
