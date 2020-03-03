package com.liyutao.dp.state.thread;

/**
 * @auther lytstart
 * @create 2020-02-29-17:40
 */
public class NewState extends ThreadState_ {
    private Thread_ t;

    public NewState(Thread_ t) {
        this.t = t;
    }

    @Override
    public void move(Action input) {
        if (input.msg == "start")
            t.state = new RunningState(t);
    }

    @Override
    public void run() {

    }
}
