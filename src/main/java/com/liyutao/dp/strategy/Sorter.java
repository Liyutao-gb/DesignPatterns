package com.liyutao.dp.strategy;

/**
 * @auther lytstart
 * @create 2020-01-06-11:13
 * 怎么对Cat进行排序?
 * compareTo:
 *      Returns: a negative integer, zero, or a positive integer as this object is less than, equal to,
 * or greater than the specified object.
 */
public class Sorter<T> {

    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[minPos], arr[j]) == 1 ? j : minPos;
            }

            swap(arr, i, minPos);
        }
    }

    public void swap(T[] arr, int i, int minPos) {
        T temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }

}
