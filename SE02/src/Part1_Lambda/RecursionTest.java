package Part1_Lambda;

public class RecursionTest {
    public static void main(String[] args) {
        int input = 100;
        int answer = recursion(100);
        System.out.println(answer);
    }
    public static int recursion(int n){
        if (n == 0){
            return n;
        }
        return n + recursion((n-1));
    }
}
