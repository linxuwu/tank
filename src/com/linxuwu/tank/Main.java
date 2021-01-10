package com.linxuwu.tank;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        GameFactory gameFactory = new DefaultGameFactory();

        //初始化地方坦克
        for (int i =0; i < 5; i++) {
            tf.tanks.add(gameFactory.createTank(50 + i * 60, 200, Dir.DOWN, Group.BAD, tf));
        }

        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
