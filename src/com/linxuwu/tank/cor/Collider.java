package com.linxuwu.tank.cor;

import com.linxuwu.tank.GameObject;

public interface Collider {

    boolean collide(GameObject o1, GameObject o2);

}
