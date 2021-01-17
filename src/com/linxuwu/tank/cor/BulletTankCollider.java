package com.linxuwu.tank.cor;

import com.linxuwu.tank.Bullet;
import com.linxuwu.tank.GameObject;
import com.linxuwu.tank.Tank;

public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Bullet) {
            Bullet bullet = (Bullet)o2;
            Tank tank = (Tank)o1;
            //todo 碰撞实现在这里实现 copy code from method collideWith
            if(bullet.collideWith(tank)) {
                return false;
            }
        } else if(o1 instanceof Bullet && o2 instanceof Tank) {
            collide(o2, o1);
        } else {
            return false;
        }

        return true;
    }
}
