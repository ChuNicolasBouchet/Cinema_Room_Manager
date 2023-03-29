package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        int profit;
        if ((rows * seats) < 60) {
            profit = (rows * seats) * 10;
        } else {
            int first = rows / 2;
            int back = rows - first;
            profit = ((first * seats) * 10) + ((back * seats) * 8);
        }
        System.out.println("Total income:");
        System.out.println("$" + profit);
    }
}