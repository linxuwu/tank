package com.linxuwu.tank;

import java.awt.*;

public abstract class BaseBullet {

    /**
     * 存活
     */
    protected boolean living = true;

    protected abstract void paint(Graphics g);

    protected abstract void collideWith(BaseTank tank);
}
