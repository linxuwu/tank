package com.linxuwu.tank;

public abstract class GameFactory {

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

}
