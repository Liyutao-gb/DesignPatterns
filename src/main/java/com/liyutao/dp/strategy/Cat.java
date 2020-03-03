package com.liyutao.dp.strategy;

/**
 * @auther lytstart
 * @create 2020-01-06-11:18
 * 怎么对猫进行排序？
 * 对猫比较大小的策略指定
 * 如果只是实现Comparable接口，compareTo只能写一种排序方式
 * 如果使用Comparator策略模式，除了可以用WeightComparator外，还可以用HeightComparator（指定属性比较）
 */
public class Cat implements Comparable<Cat> {
    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public int compareTo(Cat c) {
//        Cat c = (Cat)o;
        if (this.weight < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
