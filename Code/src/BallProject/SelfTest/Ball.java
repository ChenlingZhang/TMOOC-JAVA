package BallProject.SelfTest;

import cn.tedu.util.App;

import java.awt.*;

public class Ball  extends App{
    public double x_Position;
    public double y_Position;
    public double radios;
    public double xSpeed;
    public double ySpeed;
    public int red;
    public int green;
    public int blue;
    public Color color;

    public Ball(){
        radios = Math.random()*20;
        x_Position = Math.random()*800-radios;
        y_Position = Math.random()*600-radios;
        xSpeed = Math.random()*6;
        ySpeed = Math.random()*6;
        red = (int)(Math.random()*256);
        green = (int)(Math.random()*256);
        blue = (int)(Math.random()*256);
    }
    public void move(){
        x_Position += xSpeed;
        y_Position += ySpeed;
        if (x_Position - radios > 800 || x_Position<0) {
            xSpeed = -xSpeed;
        }else if (y_Position -radios > 600 || y_Position < 0){
            ySpeed = -ySpeed;
        }
    }

    public boolean isEaten(Ball ball){
        double bigBall_X = x_Position, bigBall_Y = y_Position, bigBallD = radios;
        double smmallBall_X = ball.x_Position, smallBall_Y = ball.y_Position, smallBallD = ball.radios;
        if (smallBallD > bigBallD){
            return false;
        }
        double x_Distance = (bigBall_X + bigBallD/2)-(smmallBall_X+smallBallD/2);
        double y_Distange = (bigBall_Y+ bigBallD/2) - (smallBall_Y+smallBallD/2);
        double radioDistance = Math.sqrt(Math.pow(x_Distance,2)+Math.pow(y_Distange,2));
        boolean isEaten = radioDistance<bigBallD/2-smallBallD/2;

        if (isEaten){
            double R = bigBallD/2;
            double r = smallBallD/2;
            double Area = Math.PI* (Math.pow(R,2) + Math.pow(r,2));
            this.radios = Math.sqrt(Area/Math.PI);

        }
        return isEaten;
    }

    public void paint(Graphics2D g){
        g.setColor(new Color(red,green,blue));
        g.fillOval((int) x_Position,(int)y_Position,(int)radios,(int)radios);
    }


}
