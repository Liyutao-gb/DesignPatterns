package com.liyutao.dp.observer.v5;

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

    //控制块
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
        for (Observer o : observers) {
            o.actionWakeUp();
        }
    }
}

interface Observer{
    void actionWakeUp();
}

class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionWakeUp() {
        feed();
    }
}

class Mum implements Observer {
    public void hug() {
        System.out.println("mum hugging...");
    }

    @Override
    public void actionWakeUp() {
        hug();
    }
}

class Dog implements Observer {
    public void wang() {
        System.out.println("dog wangwang...");
    }

    @Override
    public void actionWakeUp() {
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
