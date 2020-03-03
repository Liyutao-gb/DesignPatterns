package com.liyutao.dp.builder;

/**
 * @auther lytstart
 * @create 2020-02-28-10:11
 */
public interface TerrainBuilder {
    TerrainBuilder buildWall();
    TerrainBuilder buildFort();
    TerrainBuilder buildMine();
    Terrain build();
}
