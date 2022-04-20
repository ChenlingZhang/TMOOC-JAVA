package cn.tedu.submarine;

import javax.swing.*;

/**
 * 水雷类模版
 */
public class Mine extends SeaObject {

    public Mine(int x, int y){
        super(x, y, 5, 18, 2);
    }

    @Override
    public void step() {
        y-=speed;
    }

    @Override
    public ImageIcon getImage() {
        if (this.isLive()) {
            return ImageResources.mine;
        }
        return null;
    }

    @Override
    public boolean isNeedRecycle() {
        return this.y <= 150 - this.height;
    }
}
