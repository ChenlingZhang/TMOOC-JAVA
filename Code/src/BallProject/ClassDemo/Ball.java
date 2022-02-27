package BallProject.ClassDemo;

import cn.tedu.util.App;

import java.awt.*;

public class Ball extends App {
    private int diameter;
    private int x_Position;
    private int y_Position;
    private int xSpeed;
    private int ySpeed;
    private int red;
    private int green;
    private int blue;
    private Color color;

    public Ball(){
        setDiameter((int)(Math.random()*50));
        setX_Position((int)(Math.random()*(800-this.getDiameter())));
        setY_Position((int)(Math.random()*(600-this.getDiameter())));
        setxSpeed((int)(Math.random()*(6-1)+1));
        setySpeed((int)(Math.random()*(6-1)+1));
        setRed((int)(Math.random()*256));
        setGreen((int)(Math.random()*256));
        setBlue((int)(Math.random()*256));
        setColor(new Color(this.getRed(),this.getGreen(),this.getBlue()));


    }

    public void ballMove(){
        this.setX_Position(this.getX_Position()+this.getxSpeed());
        this.setY_Position(this.getY_Position()+this.getySpeed());
        if (this.getX_Position()<0||this.getX_Position()>(800-this.getDiameter())){
            this.setxSpeed(-this.getxSpeed());
        }
        if (this.getY_Position()<0||this.getY_Position()>(600-this.getDiameter())){
            this.setySpeed(-this.getySpeed());
        }
    }

    public boolean isEaten(Ball ball){
        int bigBall_Radios = this.getDiameter()/2;
        int bigBall_Xposition = this.getX_Position();
        int bigBall_Yposition = this.getY_Position();
        int smallBall_Radios = ball.getDiameter()/2;
        int smallBall_Xposition = ball.getX_Position();
        int smallBall_Yposition = ball.getY_Position();
        int xDistance = (bigBall_Xposition + bigBall_Radios)-(smallBall_Xposition+smallBall_Radios);
        int yDistance = (bigBall_Yposition + bigBall_Radios)-(smallBall_Yposition+smallBall_Radios);
        double radioDistance = Math.sqrt(Math.pow(xDistance,2)+Math.pow(yDistance,2));
        boolean isEaten = radioDistance<bigBall_Radios-smallBall_Radios;

        if (smallBall_Radios > bigBall_Radios){
            return false;
        }
        if (isEaten){
            System.out.println("eat");
            this.setDiameter(this.getDiameter()+ball.getDiameter());
            this.setColor(ball.getColor());
        }

        return false;
    }

    public void ballPaint(Graphics2D g){
        g.setColor(this.getColor());
        g.fillOval(this.getRed(),this.getY_Position(),this.getDiameter(),this.getDiameter());
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public int getX_Position() {
        return x_Position;
    }

    public void setX_Position(int x_Position) {
        this.x_Position = x_Position;
    }

    public int getY_Position() {
        return y_Position;
    }

    public void setY_Position(int y_Position) {
        this.y_Position = y_Position;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
