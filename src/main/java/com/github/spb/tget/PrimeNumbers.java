package com.github.spb.tget;

public class PrimeNumbers {

    private static final int LIMIT = 100;

    public static void main(String[] args) {
        primeNumbersOneVersion(2);
        System.out.println();
        primeNumbersAnotherVersion(2);
    }

    static void primeNumbersOneVersion(int current) {

        if (current > LIMIT) {
            return;
        }
        for (int i = 2; i <= current; i++) {
            if (current % i == 0 && current != i) {
                break;
            }
            if (current == i) {
                System.out.print(current + "\t");
            }
        }

        current++;
        primeNumbersOneVersion(current);
    }

    static void primeNumbersAnotherVersion(int current) {

        if (current > LIMIT) {
            return;
        }
        if (isPrimeNumber(current)) {
            System.out.print(current + "\t");
        }

        current++;
        primeNumbersAnotherVersion(current);
    }

    private static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0 && number != i) {
                return false;
            }
        }
        return true;
    }
}
