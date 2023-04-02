import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int[] box1 = new int[3];
        int[] box2 = new int[3];
        for (int i = 0; i < 3; i++) {
            box1[i] = scanner.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            box2[i] = scanner.nextInt();
        }
        Arrays.sort(box1);
        Arrays.sort(box2);
        int box1size = 0;
        int box2size = 0;
        for (int j = 0; j < box1.length; j++) {
            if (box1[j] > box2[j]) {
                box1size++;
            } else if (box1[j] < box2[j]) {
                box2size++;
            }
        }
        if (box1size == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (box2size == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}