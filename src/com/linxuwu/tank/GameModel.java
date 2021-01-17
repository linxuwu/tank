package com.linxuwu.tank;

import com.linxuwu.tank.cor.BulletTankCollider;
import com.linxuwu.tank.cor.Collider;
import com.linxuwu.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameModel {

    Tank tank = new Tank(200, 300, Dir.DOWN, Group.GOOD, this);

//    List<Bullet> bullets = new ArrayList<>();
//    List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();

    private List<GameObject> objects = new ArrayList<>();

    ColliderChain colliderChain = new ColliderChain();

    public GameModel(){
        //初始化地方坦克
        for (int i =0; i < 5; i++) {
            add(new Tank(50 + i * 60, 200, Dir.DOWN, Group.BAD, this));
        }

    }

    public void add(GameObject go) {
        this.objects.add(go);
    }
    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("bullets:" + bullets.size(), 10, 60);
//        g.drawString("tanks:" + tanks.size(), 10, 80);
//        g.drawString("explodes:" + explodes.size(), 10, 100);
        g.setColor(c);

        //坦克自己最清楚自己的属性，所以画的实现在坦克实现
        tank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //互相碰撞 -- 交给碰撞器实现
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1, o2);
            }
        }

//        Iterator<Bullet> bulletIterator = bullets.iterator();
//        while (bulletIterator.hasNext()){
//            Bullet bullet = bulletIterator.next();
//            if(bullet.isLiving()) {
//                bullet.paint(g);
//            }else {
//                bulletIterator.remove();
//            }
//        }
//
//        Iterator<Tank> tankIterator = tanks.iterator();
//        while (tankIterator.hasNext()){
//            Tank tank = tankIterator.next();
//            if(tank.isLiving()) {
//                tank.paint(g);
//            }else {
//                //tankIterator.remove();
//            }
//        }
//        for (int i = 0; i < explodes.size(); i++) {
//            explodes.get(i).paint(g);
//        }
//
//
//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }

    }
}
