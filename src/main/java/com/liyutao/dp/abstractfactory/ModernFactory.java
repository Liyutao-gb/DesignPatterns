package com.liyutao.dp.abstractfactory;

/**
 * @auther lytstart
 * @create 2020-01-13-18:45
 */
public class ModernFactory extends AbstrctFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new AK47();
    }
}
