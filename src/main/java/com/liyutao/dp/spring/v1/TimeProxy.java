package com.liyutao.dp.spring.v1;

/**
 * @auther lytstart
 * @create 2020-02-27-12:38
 */
public class TimeProxy {
    public void before() {
        System.out.println("method start.." + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("method stop.." + System.currentTimeMillis());
    }
}
