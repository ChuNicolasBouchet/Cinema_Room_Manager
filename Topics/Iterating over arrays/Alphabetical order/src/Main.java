import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] stringArray = input.split(" ");
        int positiveCounter = 0;
        for (int i = 0; i < stringArray.length - 1; i++) {
            String first = stringArray[i];
            String second = stringArray[i + 1];
            int comp = first.compareTo(second);
            if (comp > 0) {
                positiveCounter++;
                break;
            }
        }
        if (positiveCounter > 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
}
