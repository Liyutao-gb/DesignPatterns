package com.liyutao.dp.prototype.v2;

/**
 * @auther lytstart
 * @create 2020-02-29-10:49
 * 深克隆：重新复制了一份新的对象，两个指针指向不同对象
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person)p1.clone();
        System.out.println(p2.age + "  " + p2.score);
        System.out.println(p2.loc);

        System.out.println(p1.loc == p2.loc); //重新复制了一份Location，指向不同对象
        p1.loc.street = "sh";
        System.out.println(p2.loc);

    }
}

class Person implements Cloneable {
    int age = 8;
    int score = 100;
    Location loc = new Location("bj", 22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
        p.loc = (Location)loc.clone();  //重新复制了一份loc对象
        return p;
    }
}

class Location implements Cloneable {
    String street;
    int roomNo;

    public Location(String street, int roomNo) {
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