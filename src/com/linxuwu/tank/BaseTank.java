package com.linxuwu.tank;

import java.awt.*;

public abstract class BaseTank {

    protected int x, y;
    protected Group group = Group.BAD;
    protected Rectangle rect = new Rectangle();
    /**
     * 存活
     */
    protected boolean living = true;

    protected boolean moving = true;

    protected Dir dir = Dir.DOWN;

    protected abstract void paint(Graphics g);

    public abstract void fire();

    public abstract void die();
}
