package com.liyutao.dp.observer.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther lytstart
 * @create 2020-02-23-21:32
 *观察者模式：钩子函数 hook/callback function
 *
 * 很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象 getSource();
 * 事件也可以形成继承体系
 *
 * ★ 观察者不能与事件源强耦合，所以观察者不持有事件源。但事件源持有观察者链条！
 *
 * 抽象主题，具体主题。抽象观察者，具体观察者。
 */
class Child {
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
        observers.add((e)->
            System.out.println("ppp")
        );
        // hook callback function
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;

        wakeUpEvent event = new wakeUpEvent(System.currentTimeMillis(), "bed", this);

        for (Observer o : observers) {
            o.actionWakeUp(event);
        }
    }
}

abstract class Event<T> {
    abstract T getSource();
}

// 事件类 fire Event
class wakeUpEvent extends Event<Child> {
    long times;
    String location;
    Child source;  // 事件源对象 e.getSource();

    public wakeUpEvent(long times, String location, Child source) {
        this.times = times;
        this.location = location;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
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
        System.out.println("dog wang...");
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
