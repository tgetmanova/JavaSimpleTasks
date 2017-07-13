package com.github.spb.tget;

public class ParenthesisBalance {

    public static boolean isBalanced(String text) {
        char[] chars = text.toCharArray();
        int openingCount = 0, closingCount = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                openingCount++;
            }
            if (chars[i] == ')') {
                closingCount++;
            }
            if (closingCount > openingCount) {
                return false;
            }
        }

        return openingCount == closingCount;
    }
}
