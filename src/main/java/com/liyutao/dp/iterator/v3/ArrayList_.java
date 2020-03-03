package com.liyutao.dp.iterator.v3;

/**
 * @auther lytstart
 * @create 2020-02-27-17:11
 */
class ArrayList_ {
    Object[] objects = new Object[10];
    // objects中下一个空的位置在哪儿，或者说，目前容器中有多少个元素
    private int index = 0;

    public void add(Object o) {
        if (index == objects.length) {
            Object[] newObjects = new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }

        objects[index] = o;
        index++;
    }

    public int size() {
        return index;
    }
}