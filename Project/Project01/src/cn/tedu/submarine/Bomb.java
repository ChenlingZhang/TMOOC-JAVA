package cn.tedu.submarine;

import javax.swing.*;

/**
 * 炸弹模版
 */
public class Bomb extends SeaObject{
    public Bomb(int x, int y){
        super(x,y,9,12,3);
    }

    @Override
    public void step() {
        y+=speed;
    }

    @Override
    public ImageIcon getImage() {
        if(this.isLive()) {
            return ImageResources.bomb;
        }
        return null;
    }

    @Override
    public boolean isNeedRecycle() {
        return this.y >= GameWorld.HEIGHT;
    }
}
