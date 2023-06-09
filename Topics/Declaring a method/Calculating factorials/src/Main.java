import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
        // write your code here
        long factorial = 0;
        if (n > 0) {
            factorial = n * factorial(n - 1);
        } else {
            factorial = 1;
        }
        return factorial;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}