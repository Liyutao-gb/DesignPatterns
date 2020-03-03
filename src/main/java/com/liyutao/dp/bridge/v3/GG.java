package com.liyutao.dp.bridge.v3;

/**
 * @auther lytstart
 * @create 2020-02-28-18:57
 * Gift -> WarmGift ColdGift WildGift
 * GiftImpl -> Flower Ring Car
 */
public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift(new Flower());
        give(mm, g);
    }

    public void give(MM mm, Gift g) {
        System.out.println(g + "gived!");
    }
}
