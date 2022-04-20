package cn.tedu.submarine;

import javax.swing.*;

/**
 * 侦查潜艇模版
 */
public class ObserverSubmarine extends SeaObject implements EnemyScore{
    public ObserverSubmarine(){
        super(63,19);
    }

    @Override
    public void step() {
        x += speed;
    }

    @Override
    public ImageIcon getImage() {
        if (this.isLive()) {
            return ImageResources.obsersubmarine;
        }
        return null;
    }

    @Override
    public int getScore() {
        return 10;
    }
}
