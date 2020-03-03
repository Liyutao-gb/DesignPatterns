package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-04-23:44
 * lazy loading 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * synchronized加在需要的地方，线程依旧不安全
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            // 妄图通过减少同步代码块的方式提高效率，然后不可行,多线程再次聚集
            synchronized (Mgr05.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // Java8新特性
            new Thread(() ->
                    System.out.println(Mgr05.getInstance().hashCode())
            ).start();
        }
    }
}
