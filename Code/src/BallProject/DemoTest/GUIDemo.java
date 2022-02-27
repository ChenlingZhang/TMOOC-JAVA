package BallProject.DemoTest;

import cn.tedu.util.App;

import java.awt.*;

/**
 * GUI 的使用：
 *  构建图形用户界面，使用GUI，知道如何显示窗口，如果在窗口里绘制内容即可
 */
public class GUIDemo extends App{
    int x = 0;
    public static void main(String[] args) {
        GUIDemo guiDemo = new GUIDemo();
        guiDemo.start();

    }

    @Override
    public void painting(Graphics2D g) {
        x+=1;
        g.setColor(new Color(233,133,33));
        g.fillOval(x,0,200,200);

    }
}

