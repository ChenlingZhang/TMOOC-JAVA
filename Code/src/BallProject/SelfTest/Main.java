package BallProject.SelfTest;

import cn.tedu.util.App;

import java.awt.*;
import java.util.Arrays;

public class Main extends App {
    Ball[] balls = new Ball[10];
    public Main(){
        for (int i = 0; i < balls.length; i++) {
            balls[i] = new Ball();
        }
        eating();
    }
    public void eating(){
        Ball[] bigBall = balls;
        Ball[] smallBall = balls;
        boolean[] eaten = new boolean[smallBall.length];
        int count = 0;
        for (int i = 0; i < bigBall.length; i++) {
            if (eaten[i]){
                continue;
            }
            for (int j = 0; j < smallBall.length; j++) {
                if (i == j){
                    continue;
                }
                if (eaten[j]){
                    continue;
                }
                if (bigBall[i].isEaten(smallBall[j])){
                    eaten[j] = true;
                    count++;
                }
            }

        }
        if (count == 0){
            return;
        }
        Ball[] arr = new Ball[smallBall.length];
        int index = 0;
        for (int i = 0; i < smallBall.length; i++) {
            if (!eaten[i]){
                arr[index++] = smallBall[i];
            }
        }
        balls = Arrays.copyOf(arr,arr.length-count);
    }

    @Override
    public void painting(Graphics2D g) {
        for (Ball ball:balls) {
            ball.move();
            ball.paint(g);
        }
    }



    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

}
