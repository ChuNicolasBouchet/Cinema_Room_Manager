import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        long firstValue = scanner.nextLong();
        char operator = scanner.next().charAt(0);
        long secondValue = scanner.nextLong();

        switch (operator) {
            case '+' -> System.out.println(firstValue + secondValue);
            case '-' -> System.out.println(firstValue - secondValue);
            case '/' -> {
                if (secondValue == 0) {
                    System.out.println("Division by 0!"); 
                        }
                else {
                    System.out.println(firstValue / secondValue);
                }
            }
            case '*' -> System.out.println(firstValue * secondValue);
            default -> System.out.println("Unknown operator");
        }
    }
}
