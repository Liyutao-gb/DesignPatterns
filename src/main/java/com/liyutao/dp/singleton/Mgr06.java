package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-05-0:00
 * 双重检查，线程安全
 * 一定要加volatile（指令重排）
 *    volatile：线程间可见、防止指令重排
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE; // JIT

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {  // 第一次避免了许多不必要的判断
            // 双重检查单例写法,多线程再次聚集
            synchronized (Mgr06.class) {
                if (INSTANCE == null) { // 线程同步
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->        // Java8新特性
                    System.out.println(Mgr06.getInstance().hashCode())
            ).start();
        }
    }
}
