package cinema;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Cinema {
    public static class tariffs {
        static int frontTicket = 10;
        static int backTicket = 8;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = checkArrayInput("the number of rows");
        int seats = checkArrayInput("the number of seats in each row");

        String[][] seatsMatrix = new String[rows][seats];
        for (String[] rowArray : seatsMatrix) Arrays.fill(rowArray, "S");

        showMenu();

        int choice;
        do {
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    showTheSeats(seatsMatrix);
                }
                case 2 -> {
                    String[][] newSeatsMatrix = buyATicket(seatsMatrix);
                    seatsMatrix = newSeatsMatrix;
                }
                case 3 -> {
                    showStatistics(seatsMatrix);
                }
                case 0 -> {
                    System.out.println("goodbye!!");
                                    }
                default -> System.out.println("This choice does not exist!");
            }
        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("""
                
                1. Show the seats
                2. Buy a ticket
                3. Statistics
                0. Exit
                """);
    }
    public static void showTheSeats(String[][] seatsMatrix) {
        System.out.println("Cinema:");
        StringBuilder seatsRanks = new StringBuilder("  ");
        for ( int s = 1; s <= seatsMatrix[0].length; s++) {
            seatsRanks.append(s).append(" ");
        }
        System.out.println(seatsRanks);

        for (int i = 0; i < seatsMatrix.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seatsMatrix[i].length; j++) {
                System.out.print(seatsMatrix[i][j] + " ");
            }
            System.out.println();
        }
        showMenu();
    }
    public static String[][] buyATicket(String[][] seatsMatrix) {
        Scanner scanner = new Scanner(System.in);
        boolean purchased = false;
        do {
            int row = 0;
            int seat = 0;
            do {
                System.out.println("Enter a row number:");
                row = scanner.nextInt();
                if (row <= 0 || row > seatsMatrix.length) {
                    System.out.println("Wrong input!");
                }
            } while (row <= 0 || row > seatsMatrix.length);
            do {
                System.out.println("Enter a seat number in that row:");
                seat = scanner.nextInt();
                if (seat <= 0 || seat > seatsMatrix[0].length) {
                    System.out.println("Wrong input!");
                }
            } while (seat <= 0 || seat > seatsMatrix[0].length);

            if (seatsMatrix[row - 1][seat - 1] != "B") {
                int ticketPrice = ticketPrice(seatsMatrix, row);
                System.out.println("Ticket price: $" + ticketPrice);
                seatsMatrix[row - 1][seat - 1] = "B";
                purchased = true;
            } else {
                System.out.println("That ticket has already been purchased!");
            }
            System.out.println();
        } while (!purchased);

        showMenu();
        return seatsMatrix;
    }

    public static void showStatistics(String[][] seatsMatrix) {
        int purchased = 0;
        int totalSeats = seatsMatrix.length * seatsMatrix[0].length;
        int totalIncome = 0;
        int currentIncome = 0;
        for (int i = 0; i < seatsMatrix.length; i++) {
            totalIncome += ticketPrice(seatsMatrix, i + 1) * seatsMatrix.length;
            for (int j = 0; j < seatsMatrix[i].length; j++) {
                if (Objects.equals(seatsMatrix[i][j], "B")) {
                    purchased++;
                    currentIncome += ticketPrice(seatsMatrix, i + 1);
                }
            }
        }
        float percentage = (float) (purchased * 100) / totalSeats;
        String statistics = "Number of purchased tickets: %d %nPercentage: %.2f%% %nCurrent income: $%d %nTotal income: $%d"
                .formatted(purchased, percentage, currentIncome, totalIncome);
        System.out.println(statistics);
        showMenu();
    }

    public static int ticketPrice(String[][] seatsMatrix, int row) {
        int ticketPrice = 0;
        if ((seatsMatrix[0].length * seatsMatrix.length) < 60) {
            ticketPrice = tariffs.frontTicket;
        } else {
            int front = seatsMatrix.length / 2;
            if (row <= front) {
                ticketPrice = tariffs.frontTicket;
            } else {
                ticketPrice = tariffs.backTicket;
            }
        }
        return ticketPrice;
    }

    public static int checkArrayInput(String matter) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        do {
            System.out.printf("Enter %s:%n", matter);
            value = scanner.nextInt();
            if (value <= 0) {
                System.out.printf("Error : %s must be greater than zero.%n", matter);
            }
        } while (value <= 0);
        return value;
    }

}