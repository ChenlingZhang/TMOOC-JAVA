package cn.tedu.submarine;

import javax.swing.*;

/**
 * 鱼类潜艇类模版
 */
public class TorpedoSubmarine extends SeaObject implements EnemyScore{
    public TorpedoSubmarine(){
        super(64,20);
    }

    @Override
    public void step() {
        x+=speed;
    }

    @Override
    public ImageIcon getImage() {
        if(this.isLive()) {
            return ImageResources.torpedosubmarine;
        }
        return null;
    }

    @Override
    public int getScore() {
        return 40;
    }
}
