package com.liyutao.dp.singleton;

/**
 * @auther lytstart
 * @create 2020-01-04-22:38
 * 单例模式应用场景：只需要有一个实例存在
 *                 比如各种Mgr
 *                 比如各种Factory
 */
public class Main {
    public static void main(String[] args) {
        Mgr01 mgr = Mgr01.getInstance();
    }
}
