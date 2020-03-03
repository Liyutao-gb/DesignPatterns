package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-04-23:21
 * lazy loading
 * 也称懒汉式
 * 可以通过synchronized解决，但也带来效率下降。
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {
    }

    public static synchronized Mgr04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->        // Java8新特性
                    System.out.println(Mgr04.getInstance().hashCode())
            ).start();
        }
    }
}
