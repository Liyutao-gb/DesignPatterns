package com.liyutao.dp.state.thread;

/**
 * @auther lytstart
 * @create 2020-02-29-17:40
 */
public class Thread_ {
    ThreadState_ state;

    void move(Action input) {
        state.move(input);
    }

    void run() {
        state.run();
    }
}
