package Part3_Exception;

public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("Program Start");
        try{
            String s = null;
            System.out.println(s.length());

        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Program Stop");
    }
}
