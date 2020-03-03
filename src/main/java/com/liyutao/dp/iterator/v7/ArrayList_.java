package com.liyutao.dp.iterator.v7;

/**
 * @auther lytstart
 * @create 2020-02-27-17:11
 * <p>
 * E:Element  T:Type  K:Key  V:Value
 */
class ArrayList_<E> implements Collection_<E> {
    E[] objects = (E[]) new Object[10];
    // objects中下一个空的位置在哪儿，或者说，目前容器中有多少个元素
    private int index = 0;

    public void add(E o) {
        if (index == objects.length) {
            E[] newObjects = (E[]) new Object[objects.length * 2];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }

        objects[index] = o;
        index++;
    }

    public int size() {
        return index;
    }

    public Iterator_<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator_<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >= index)
                return false;
            return true;
        }

        @Override
        public E next() {
            E o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }
}
