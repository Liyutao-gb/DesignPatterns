package com.liyutao.dp.abstractfactory;

/**
 * @auther lytstart
 * @create 2020-01-13-18:45
 */
public class MagicFactory extends AbstrctFactory {
    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
