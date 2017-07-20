package com.github.spb.tget;

import java.util.Stack;

public class ParenthesisBalance {

    private static String OPENING = "[{(";
    private static String CLOSING = "]})";

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

    public static Boolean isBalancedMultiple(String text) {
        char[] chars = extractBraces(text).toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (isClosing(chars[i])) {
                if (stack.empty()){
                    return false;
                }

                char expectedOpening = 0;
                switch (chars[i]) {
                    case ']':
                        expectedOpening = '[';
                        break;
                    case '}':
                        expectedOpening = '{';
                        break;
                    case ')':
                        expectedOpening = '(';
                        break;
                }
                if (stack.pop() != expectedOpening) {
                    return false;
                }
            }

            if (isOpening(chars[i])) {
                stack.push(chars[i]);
            }
        }

        if (stack.empty()) {
            return true;
        }

        return false;
    }

    private static Boolean isClosing(char c) {
        return CLOSING.contains(String.valueOf(c));
    }

    private static Boolean isOpening(char c) {
        return OPENING.contains(String.valueOf(c));
    }

    private static String extractBraces(String text) {
        return text.replaceAll("[^\\[\\](){}]", "");
    }
}
