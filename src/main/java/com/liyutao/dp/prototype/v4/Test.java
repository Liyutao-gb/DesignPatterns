package com.liyutao.dp.prototype.v4;

/**
 * @auther lytstart
 * @create 2020-02-29-10:49
 * 深克隆：
 *  String也需要进一步深克隆吗？
 *      String类型不需要进行深克隆。（常量池）
 *  StringBuilder("") 或 new String呢？
 *      两个指针指向同一个StringBuilder("")
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println("p1.loc == p2.loc? " + (p1.loc == p2.loc));

        p1.loc.street.reverse();
        System.out.println(p2.loc.street);
    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;
    Location loc = new Location(new StringBuilder("bj"), 22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location)loc.clone();  //重新复制了一份loc对象
        return p;
    }
}

class Location implements Cloneable {
    StringBuilder street;
    int roomNo;

    public Location(StringBuilder street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}