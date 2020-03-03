package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-04-22:41
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但多线程访问会有影响
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {
//            try { // 多个线程在这聚集,从而new出不同对象
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->        // 简写 并且 只有一句话,可以去掉大括号
                    System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }
//        匿名内部类
//        new Thread(new Runnable() {   // Lamdba表达式是对只有一个方法的匿名接口Runnable
//            @Override
//            public void run() {
//                //
//            }
//        }).start();
    }
}
