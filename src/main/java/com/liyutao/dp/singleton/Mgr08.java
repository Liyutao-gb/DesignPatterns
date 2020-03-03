package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-05-12:36
 * Effective Java作者的写法
 * 枚举单例：不仅可以解决线程同步，还可以防止反序列化
 * 不会被反序列化，因为枚举类没有构造方法,没法构造对象
 * 规定：枚举没有构造方法
 */
public enum Mgr08 {

    INSTANCE;

    public void m() {}

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            new Thread(()->
                    System.out.println(Mgr08.INSTANCE.hashCode())
            ).start();
        }
    }
}
