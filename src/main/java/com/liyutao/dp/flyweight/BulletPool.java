package com.liyutao.dp.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @auther lytstart
 * @create 2020-02-26-18:33
 *
 * 模拟场景：有一堆子弹，如果没弹出Frame，living = true；如果弹出Frame，living = false。
 *       当需要子弹对象时，在子弹池中挨着遍历，找到一个活的；如果都活着，那就new一个子弹。
 */
class Bullet {
    public UUID id = UUID.randomUUID();
    boolean living = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}

public class BulletPool {
    List<Bullet> bullets = new ArrayList<>();
    {
        for (int i = 0; i < 5; i++)
            bullets.add(new Bullet());
    }

    public Bullet getBullets() {

        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if (!bullet.living) return bullet;
        }

        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool bp = new BulletPool();

        for (int i = 0; i < 10; i++) {
            Bullet b = bp.getBullets();
            System.out.println(b);
        }
    }
}
