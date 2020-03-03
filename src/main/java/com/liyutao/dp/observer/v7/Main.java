package com.liyutao.dp.observer.v7;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther lytstart
 * @create 2020-02-23-21:32
 *
 * 很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要 事件源对象
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

//        System.out.println(this.getClass().getName());
        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed", this);

        for (Observer o : observers) {
            o.actionWakeUp(event);
        }
    }
}

// 事件类 fire Event
class wakeUpEvent {
    long times;
    String location;
    Child source;  // 发出事件的事件源对象   e.getSource();

    public wakeUpEvent(long times, String location, Child source) {
        this.times = times;
        this.location = location;
        this.source = source;
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