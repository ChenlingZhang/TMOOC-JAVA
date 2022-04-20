package HomeWork01;

public class Area {
    private double length;
    private double height;

    public double getLength() {
        return length;
    }

    public Area(double length) {
        this.length = length;
    }

    public Area(double length, double height) {
        this.length = length;
        this.height = height;
    }

    public double rectangleArea(double length, double height){
        return  length*height;
    }

    public double circleArea(double length){
        return  Math.floor(Math.pow((length/2),2)*Math.PI);
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
