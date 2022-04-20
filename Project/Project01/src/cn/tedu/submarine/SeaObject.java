package cn.tedu.submarine;

import javax.swing.*;
import java.awt.*;

public abstract class SeaObject {
    public static final int LIVE = 0;
    public static final int DEATH = 1;

    public int currentState = LIVE; // 默认状态为活着的状态

    int x;
    int y;
    int width;
    int height;
    int speed;

    /**
     *
     * @param width
     * @param height
     * 此构造方法是专门为3种潜艇提供的构造方法。
     * 因为潜艇宽高不同，所以宽高不能血丝，做成形式参数，由具体的子类传递它的宽高数据
     * x y speed 初始化的数据都是一样的，写死即可
     */
    public SeaObject(int width, int height){
        this.width = width;
        this.height = height;
        x = -width;
        y = (int)(Math.random()*(GameWorld.HEIGHT-height-150)+150);
        speed = (int)(Math.random()*(3-1)+1);
    }

    /**
     * 因为赋值的过程是重复的，此构造方法是为战舰，深水炸弹，鱼类和水雷提供的
     * 因此这4个类的具体数据都不同，所以做成形式参数，具体由当前类使用时提供
     * @param x
     * @param y
     * @param width
     * @param height
     * @param speed
     */
    public SeaObject(int x, int y, int width, int height, int speed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;

    }

    /**
     * 判断当前调用方法这个对象，是否是 死亡状态
     * @return true/false
     */
    public boolean isDead(){
        return currentState == DEATH;
    }

    /**
     * 判断当前调用方法这个对象，是否是活着的状态
     * @return true/false
     */
    public boolean isLive(){
        return currentState == LIVE;
    }

    public void Dead(){
        this.currentState = DEATH;
    }

    public void paintImage(Graphics g){
        if(this.getImage() != null) {
            ImageIcon imageIcon = this.getImage();
            imageIcon.paintIcon(null, g, this.x, this.y);
        }
    }

    public abstract void step();
    public abstract ImageIcon getImage();

    public SeaObject shootThunder(){
        // 创建雷对象时，先要将雷对象的x和y坐标算出来
        int x = this.x + this.width;
        int y = this.y - 5;
        // 判断对象种类
        if(this instanceof MineSubmarine){
            return new Mine(x,y);
        }
        else if (this instanceof TorpedoSubmarine){
            return new Torpedo(x,y);
        }
        else return null;
    }
    public boolean isNeedRecycle(){
        return this.x >= GameWorld.WIDTH; // 判断潜艇是否超出屏幕的宽
    }
    public boolean isHit(SeaObject seaObject){
        int x1 = this.x-seaObject.width;
        int x2 = this.x+this.width;
        int y1 = this.y- seaObject.width;
        int y2 = this.y+this.height;
        return (seaObject.x < x2 && seaObject.x >= x1) && (seaObject.y >= y1 && seaObject.y <= y2);
    }
}
