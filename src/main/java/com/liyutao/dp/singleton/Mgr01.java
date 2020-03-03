package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-04-22:41
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类加载时就完成实例化
 */
public class Mgr01 {
    // 类一旦被加载就实例化
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01() { // 构造方法是私有的,其他类new不出来
    }

    public static Mgr01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 m1 = Mgr01.getInstance();
        Mgr01 m2 = Mgr01.getInstance();
        System.out.println(m1 == m2);
    }

}
