package com.liyutao.dp.builder;

/**
 * @auther lytstart
 * @create 2020-02-28-10:05
 * 创建多个对象时：
 *      初始化Person时，如果new Person(...)的话，需要的传参数，不需要的传空值，这样的话很不高效
 */
public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        Terrain t = builder.buildFort().buildMine().buildWall().build();
        //new Terrain(Wall w, Fort f, Mine m)

        //初始化Person需要的构建，不需要的注掉即可。
        Person p = new Person.PersonBuilder()
                .basicInfo(1, "zhangsan", 18)
                //.score(20)
                .weight(200)
                //.loc("bj", "23")
                .build();
    }
}
