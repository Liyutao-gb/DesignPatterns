package com.liyutao.dp.strategy;

/**
 * @auther lytstart
 * @create 2020-01-06-11:47
 * 自己定义一个Comparable接口,实现compareTo方法
 * 泛型 Comparable<T> 实现此接口时需指定类型
 */
public interface Comparable<T> {

    int compareTo(T o);

}
