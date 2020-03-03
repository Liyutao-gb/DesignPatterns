package com.liyutao.dp.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther lytstart
 * @create 2020-02-23-21:32
 *
 * 分离观察者与被观察者
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed");

        for (Observer o : observers) {
            o.actionWakeUp(event);
        }
    }
}

// 事件类 fire Event
class wakeUpEvent{
    long times;   // 时间
    String location;  // 地点

    public wakeUpEvent(long times, String location) {
        this.times = times;
        this.location = location;
    }
}

interface Observer{
    void actionWakeUp(wakeUpEvent event);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionWakeUp(wakeUpEvent event) {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionWakeUp(wakeUpEvent event) {
        hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("dog wangwang...");
    }

    @Override
    public void actionWakeUp(wakeUpEvent event) {
        wang();
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        // do sth
        c.wakeUp();
    }
}
