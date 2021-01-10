package com.linxuwu.tank;

import java.awt.*;

public abstract class BaseExplode {

    /**
     * 存活
     */
    protected boolean living = true;

    protected abstract void paint(Graphics g);
}
