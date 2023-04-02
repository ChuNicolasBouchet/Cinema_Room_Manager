import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in) ;
        int size = scanner.nextInt();
        int[] inp = new int[size];
        int r = 0;
        for (int i = 0; i < size; i++){
            inp[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        for (int j = 0; j < inp.length; j++) {
            if (inp[j] > n) {
                 r += inp[j];
            }
        }
        System.out.println(r);
    }
}