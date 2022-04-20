package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷类潜艇模版
 */
public class MineSubmarine extends SeaObject implements EnemyLife{
    public MineSubmarine(){
        super(63,19);
    }

    @Override
    public void step() {
        x+=speed;
    }

    @Override
    public ImageIcon getImage() {
        if(this.isLive()) {
            return ImageResources.minesubmarine;
        }
        return null;
    }

    @Override
    public int getLife() {
        return 1;
    }
}
