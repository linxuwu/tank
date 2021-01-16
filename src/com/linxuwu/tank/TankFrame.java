package com.linxuwu.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    GameModel gm = new GameModel();

    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;

    public TankFrame()  {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("tank war");
        this.setVisible(true);

        this.addKeyListener(new MyKeyListener());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    //解决闪烁现象，先在内存画完，再一次性画出来
    //update在paint之前调用
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * paint被系统调用
     * g相当于画笔，在面板上想画啥就画啥
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        gm.paint(g);
    }

    //处理键盘监听
    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
            }
            setMainTainTankDir();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    gm.tank.fire();
                    break;

            }
            setMainTainTankDir();

        }

        private void setMainTainTankDir() {
            if(!bL && !bU && !bR && !bD)
                gm.tank.setMoving(false);
            else {
                gm.tank.setMoving(true);

                if(bL)  gm.tank.setDir(Dir.LEFT);
                if(bR)  gm.tank.setDir(Dir.RIGHT);
                if(bU)  gm.tank.setDir(Dir.UP);
                if(bD)  gm.tank.setDir(Dir.DOWN);
            }
        }
    }
}
