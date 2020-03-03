package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-05-12:02
 * 静态内部类的方式
 * JVM保证单例
 * 加载外部类时不会加载内部类,这样可以实现懒加载，当调用getInstance时，才会加载实例
 */
public class Mgr07 {

    private Mgr07() {
    }

    private static class Mgr07Hodler {
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return Mgr07Hodler.INSTANCE;  // 调用Mgr07Holder类
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() ->
                    System.out.println(Mgr07.getInstance().hashCode())
            ).start();
        }
    }
}
