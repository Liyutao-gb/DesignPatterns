package com.liyutao.dp.iterator.v7;

/**
 * @auther lytstart
 * @create 2020-02-27-17:10
 */
public interface Collection_<E> {
    void add(E o);
    int size();

    Iterator_<E> iterator();
}
