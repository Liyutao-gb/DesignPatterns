package com.liyutao.dp.iterator.v2;


/**
 * @auther lytstart
 * @create 2020-02-27-16:52
 * v1：构建一个容器，可以添加对象
 * v2：用链表来实现一个容器
 */
public class Main {
    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new String("s" + i));
        }
        System.out.println(list.size());
    }
}

/*
 * 相比数组，这个容器不用考虑边界问题，可以动态扩容
 */
class LinkedList_ {
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