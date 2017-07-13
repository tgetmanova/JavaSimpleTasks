package com.github.spb.tget;

import java.util.Arrays;
import java.util.Scanner;

public class LuckyTicket {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****Enter \"Q\" to quit****");
            System.out.println("Enter ticket number:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")){
                return;
            }

            boolean isLucky;
            if (input.length() % 2 == 0) {
                isLucky = isLuckyTicket(input, algorithmEvenNumber);
            } else {
                isLucky = isLuckyTicket(input, algorithmOddNumber);
            }
            System.out.println("Your ticket is " + (isLucky ? "lucky" : "not lucky"));
        }
    }

    static boolean isLuckyTicket(String ticketNumber, LuckyTicketAlgorithm algorithm) {
        if (ticketNumber == null) {
            throw new IllegalArgumentException("ticketNumber cannot be null");
        }
        if (ticketNumber.isEmpty()) {
            throw new IllegalArgumentException("ticketNumber cannot be empty");
        }
        if (!ticketNumber.matches("[0-9]+")) {
            throw new IllegalArgumentException("ticketNumber should contain only digits");
        }

        return algorithm.isLucky(ticketNumber);
    }

    static LuckyTicketAlgorithm algorithmEvenNumber = s -> {
        int[] ints = Arrays.asList(s.split(""))
                .stream()
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();

        int sumLeft = 0, sumRight = 0;

        for (int i = 0; i < ints.length / 2; i++) {
            sumLeft += ints[i];
        }

        for (int i = ints.length / 2; i < ints.length; i++) {
            sumRight += ints[i];
        }

        return sumLeft == sumRight;
    };

    static LuckyTicketAlgorithm algorithmOddNumber = s -> {
        int[] ints = Arrays.asList(s.split(""))
                .stream()
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();

        int middleIndex = (int) Math.floor(ints.length / 2);

        int sumLeft = 0, sumRight = 0;

        for (int i = 0; i < middleIndex; i++) {
            sumLeft += ints[i];
        }

        for (int i = middleIndex + 1; i < ints.length; i++) {
            sumRight += ints[i];
        }

        return sumLeft == sumRight;
    };

    @FunctionalInterface
    interface LuckyTicketAlgorithm {
        boolean isLucky(String number);
    }
}
