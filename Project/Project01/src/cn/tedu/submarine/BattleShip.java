package cn.tedu.submarine;

import javax.swing.*;

/**
 * 战舰模版
 */
public class BattleShip extends SeaObject {
     private int life;

    public BattleShip() {
       super(270,124,66,26,20);
       life = 5;
    }

    public void setLife(int life){
        if (life > 0){
            this.life += life;
        }
    }

    public void subtraceLife(){
        this.life--;
    }

    public int getLife() {
        return life;
    }

    public void moveLeft(){
        this.x -= speed;
        if (this.x-speed <= 0){
            this.x = 0;
        }

    }

    public void moveRight(){
        this.x += speed;
        if (this.x+speed+this.width >=GameWorld.WIDTH ){
            this.x = GameWorld.WIDTH - this.width;
        }
    }

    @Override
    public void step() {

    }

    @Override
    public ImageIcon getImage() {
        return ImageResources.battleShip;
    }
    // 当调用深水炸弹方法时，产生一个深水炸弹
    public Bomb shootBomb(){
        return new Bomb(this.x,this.y);
    }
}
