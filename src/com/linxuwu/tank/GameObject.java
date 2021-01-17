package com.linxuwu.tank;

import java.awt.*;

/**
 * 名称用抽象类
 * 形容词用接口
 */
public abstract class GameObject {

    int x, y;

    abstract public void paint(Graphics g);
}
