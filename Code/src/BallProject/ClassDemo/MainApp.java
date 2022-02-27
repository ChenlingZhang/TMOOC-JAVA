package BallProject.ClassDemo;
import cn.tedu.util.App;

import java.awt.*;

public class MainApp extends App {
    Ball[] balls = new Ball[100];
    public MainApp(){
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball();
        }
    }
    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.start();
    }

    @Override
    public void painting(Graphics2D g) {
        for (Ball ball:balls) {
            ball.ballMove();
            ball.ballPaint(g);
        }
    }
}
