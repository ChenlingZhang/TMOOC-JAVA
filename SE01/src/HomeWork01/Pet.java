package HomeWork01;

public class Pet {
    private String name;
    private double weight;

    public Pet(String name, double weight){
        setName(name);
        setWeight(weight);
    }

    public void run(){
        System.out.println(getName() + " is running...");
    }
    public void hunt(){
        System.out.println(getName() + " is hunting...");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void  setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
}
