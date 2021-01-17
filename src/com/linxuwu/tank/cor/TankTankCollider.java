package com.linxuwu.tank.cor;

import com.linxuwu.tank.Bullet;
import com.linxuwu.tank.GameObject;
import com.linxuwu.tank.Tank;

public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank)o1;
            Tank tank2 = (Tank)o2;
            if(tank1.getRect().intersects(tank2.getRect())) {
                tank1.back();
                tank2.back();
            }
        }
        return true;
    }
}
