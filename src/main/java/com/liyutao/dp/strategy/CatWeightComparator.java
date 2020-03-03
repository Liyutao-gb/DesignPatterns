package com.liyutao.dp.strategy;

/**
 * @auther lytstart
 * @create 2020-01-06-12:48
 */
public class CatWeightComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight < o2.weight) return -1;
        else if (o1.weight > o2.weight) return 1;
        else return 0;
    }

}
