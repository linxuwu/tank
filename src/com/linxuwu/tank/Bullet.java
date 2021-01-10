package com.linxuwu.tank;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Bullet {

    /**
     * 子弹速度
     */
    private static final int SPEED = 10;
    /**
     * 子弹宽度
     */
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    /**
     * 子弹高度
     */
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    /**
     * 子弹所占矩形面积
     */
    Rectangle rect = new Rectangle();

    /**
     * 坐标x, y
     */
    private int x, y;
    /**
     * 方向
     */
    private Dir dir;

    /**
     * 存活
     */
    private boolean living = true;
    TankFrame tf = null;
    private Group group = Group.BAD;


    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            default:
                return;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                return;
        }

        //update rect
        rect.x = this.x;
        rect.y = this.y;

       if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
           living = false;
       }
    }

    /**
     * 碰撞检测
     * @param tank
     */
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) {
            return;
        }

        //TODO: rect来记录子弹的位置
        //Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        //Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);

        if(rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(new Explode(eX, eY, tf));
        }
    }

    private void die() {
        this.living = false;
    }
}
