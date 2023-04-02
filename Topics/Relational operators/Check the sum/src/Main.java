import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int[] inputArray = new int[3];
        for (int i = 0; i < 3; i++) {
            inputArray[i] = scanner.nextInt();
        }
        if (inputArray[0] + inputArray[1] == 20) {
            System.out.println(true);
        } else if (inputArray[0] + inputArray[2] == 20) {
            System.out.println(true);
        } else if (inputArray[1] + inputArray[2] == 20) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}