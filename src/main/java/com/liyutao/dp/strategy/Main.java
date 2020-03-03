package com.liyutao.dp.strategy;

import java.util.Arrays;
/**
 * @auther lytstart
 * @create 2020-01-06-11:01
 * 策略模式： Comparator(可以指定属性比较)是    Comparable(compareTo只能写一种比较策略)不是
 *
 * exterme programming
 * 排序对象 + 对象类型
 * Client        →        Comparator
 *
 *                            ↑
 *
 *                  DogC    Cat1   Cat2
 */
public class Main {
    public static void main(String[] args) {
//        int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] a = {new Cat(3, 5), new Cat(5, 3), new Cat(1, 1)};
//        Dog[] a = {new Dog(3), new Dog(5), new Dog(1)};
        Sorter<Cat> sorter = new Sorter<>();
//        sorter.sort(a, (o1, o2) -> {      // lambda表达式，CatWeightComparator中只有一个方法
//            if (o1.weight < o2.weight) return -1;
//            else if (o1.weight > o2.weight) return 1;
//            else return 0;
//        });
        sorter.sort(a, new CatHeightComparator());
        System.out.println(Arrays.toString(a));
    }

}
