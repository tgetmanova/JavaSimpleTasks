package com.github.spb.tget;


import java.util.Arrays;
import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****Enter \"Q\" to quit****");
            System.out.println("Enter number:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Q")) {
                return;
            }

            boolean isPalindrome;
            if (input.length() % 2 == 0) {
                isPalindrome = isPalindrome(input, PalindromeNumber::isPalindromeEvenNumber);
            } else {
                isPalindrome = isPalindrome(input, PalindromeNumber::isPalindromeOddNumber);
            }

            System.out.println("Your number is " + (isPalindrome ? "palindrome" : "not palindrome"));
        }
    }

    static boolean isPalindrome(String number, PalindromeAlgorithm algorithm) {
        if (number == null) {
            throw new IllegalArgumentException("number cannot be null");
        }
        if (number.isEmpty()) {
            throw new IllegalArgumentException("number cannot be empty");
        }
        if (!number.matches("[0-9]+")) {
            throw new IllegalArgumentException("number should contain only digits");
        }

        return algorithm.isPalindrome(number);
    }

    static boolean isPalindromeEvenNumber(String number) {
        int[] ints = getIntsFromStringInt(number);

        for (int i = 0; i < ints.length / 2; i++) {
            if (ints[i] != ints[ints.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    static boolean isPalindromeOddNumber(String number) {
        int[] ints = getIntsFromStringInt(number);

        for (int i = 0; i < Math.floor(ints.length / 2); i++) {
            if (ints[i] != ints[ints.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    private static int[] getIntsFromStringInt(String stringNumber) {
        return Arrays.asList(stringNumber.split(""))
                .stream()
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();
    }

    @FunctionalInterface
    interface PalindromeAlgorithm {
        boolean isPalindrome(String number);
    }
}
