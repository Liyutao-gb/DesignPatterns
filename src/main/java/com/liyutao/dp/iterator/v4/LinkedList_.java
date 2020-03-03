package com.liyutao.dp.iterator.v4;

/**
 * @auther lytstart
 * @create 2020-02-27-17:07
 */
class LinkedList_ implements Collection_ {
    Node head = null;
    Node tail = null;
    //容器中元素的个数
    private int size = 0;

    public void add(Object o) {
        Node node = new Node(o);
        node.next = null;

        if (head == null) {
            head = node;
            tail = node;
        }

        tail.next = node;
        tail = node;
        size++;
    }

    private class Node {
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    public int size() {
        return size;
    }
}
