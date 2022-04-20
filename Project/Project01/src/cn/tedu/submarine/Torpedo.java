package cn.tedu.submarine;

import javax.swing.*;

/**
 * 鱼类模版
 */
public class Torpedo extends SeaObject{
    public Torpedo(int x, int y){
        super(x,y,5,18,2);
    }

    @Override
    public void step() {
        y-=speed;
    }

    @Override
    public ImageIcon getImage() {
        if (this.isLive()) {
            return ImageResources.torpedo;
        }
        return null;
    }

    @Override
    public boolean isNeedRecycle() {
        return this.y <= -this.height;
    }
}
