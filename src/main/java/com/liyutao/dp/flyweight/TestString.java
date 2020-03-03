package com.liyutao.dp.flyweight;

/**
 * @auther lytstart
 * @create 2020-02-26-18:49
 *
 * 享元模式:intern()方法，
 *      如果String s1 = new String("abc")，常量池中已有"abc"字符串，那么就不用再new字符串"abc"了，
 * 直接指向常量池中已有的字符串"abc"。
 *
 * 组合性享元：比如"A","B","ABABBA".
 *  组合模式compsite
 */
public class TestString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s3 == s4);
        System.out.println(s3.intern() == s1);
        System.out.println(s3.intern() == s4.intern());
    }
}
