package com.github.spb.tget;

import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****Enter \"Q\" to quit****");
            System.out.println("Enter number:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                return;
            }

            System.out.println("Binary view " + DecToBinRecursive(Integer.parseInt(input)));
        }
    }

    static String DecToBin(String decimalString) {
        int decimalInteger = Integer.parseInt(decimalString);

        StringBuilder stringBuilder = new StringBuilder();
        int current = decimalInteger;
        while (current >= 2) {
            stringBuilder.append(current % 2);
            current /= 2;
        }
        stringBuilder.append("1");

        return stringBuilder.reverse().toString();
    }

    static String DecToBinRecursive(StringBuilder stringBuilder, int decimal) {
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
        }
        if (decimal == 0) {
            stringBuilder.append("0");
            return stringBuilder.reverse().toString();
        }
        if (decimal == 1) {
            stringBuilder.append("1");
            return stringBuilder.reverse().toString();
        }

        stringBuilder.append(decimal % 2);
        decimal /= 2;

        return DecToBinRecursive(stringBuilder, decimal);
    }

    static String DecToBinRecursive(int decimal) {
        String string = "";
        if (decimal == 0) {
            return String.format("0%s", string);
        }
        if (decimal == 1) {
            return String.format("1%s", string);
        }

        string = String.format("%s%s", decimal % 2, string);
        decimal /= 2;
        string = String.format("%s%s", DecToBinRecursive(decimal), string);

        return string;
    }
}
