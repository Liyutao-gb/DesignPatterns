package com.liyutao.dp.strategy;

/**
 * @auther lytstart
 * @create 2020-01-06-11:51
 * 对狗进行排序
 * 实现Comparable接口时指定Dog类型
 * 这样就不需要将 Object的对象 强制转化 Dog类型 了
 */
public class Dog implements Comparable<Dog> {

    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog d) {
//        Dog d = (Dog)o;
        if (this.food < d.food) return -1;
        else if (this.food > d.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
