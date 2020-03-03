package com.liyutao.dp.strategy;

/**
 * @auther lytstart
 * @create 2020-01-06-12:29
 * 比较器：写比较策略的
 */
@FunctionalInterface
public interface Comparator<T> {

    int compare(T o1, T o2);

    default void m() {
        System.out.println("m");
    }
}
