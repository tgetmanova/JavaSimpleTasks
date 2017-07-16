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

    public static boolean isBalancedComplex(String text) {
        String extractedBraces = extractBraces(text);
        char[] chars = extractedBraces.toCharArray();
        int openingParenthesisCount = 0, closingParenthesisCount = 0;
        int openingBraceCount = 0, closingBraceCount = 0;
        int openingBracketCount = 0, closingBracketCount = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    openingParenthesisCount++;
                    break;
                case ')':
                    closingParenthesisCount++;
                    if ((closingBraceCount < openingBraceCount || closingBracketCount < openingBracketCount)
                            && !consistentBefore(i, extractedBraces.substring(0, i + 1))) {
                        return false;
                    }
                    break;
                case '{':
                    openingBraceCount++;
                    break;
                case '}':
                    closingBraceCount++;
                    if ((closingParenthesisCount < openingParenthesisCount || closingBracketCount < openingBracketCount)
                            && !consistentBefore(i, extractedBraces.substring(0, i + 1))) {
                        return false;
                    }
                    break;
                case '[':
                    openingBracketCount++;
                    break;
                case ']':
                    closingBracketCount++;
                    if ((closingBraceCount < openingBraceCount || closingParenthesisCount < openingParenthesisCount)
                            && !consistentBefore(i, extractedBraces.substring(0, i + 1))) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalStateException("Some unexpected char: " + chars[i]);
            }

            if (closingParenthesisCount > openingParenthesisCount
                    || closingBraceCount > openingBraceCount
                    || closingBracketCount > openingBracketCount) {
                return false;
            }
        }

        return closingParenthesisCount == openingParenthesisCount
                && closingBraceCount == openingBraceCount
                && closingBracketCount == openingBracketCount;
    }

    private static boolean consistentBefore(int currentCharIndex, String stringBefore) {
        char[] chars = stringBefore.toCharArray();

        int beginIndex = findCorrespondingOpening(chars, chars[currentCharIndex]);

        switch (chars[currentCharIndex]) {
            case ')':
                return validateBracesCountWithin(stringBefore.substring(beginIndex, currentCharIndex + 1))
                        && validateBracketsCountWithin(stringBefore.substring(beginIndex, currentCharIndex + 1));
            case '}':
                return validateParenthesisCountWithin(stringBefore.substring(beginIndex, currentCharIndex + 1))
                        && validateBracketsCountWithin(stringBefore.substring(beginIndex, currentCharIndex + 1));
            case ']':
                return validateBracesCountWithin(stringBefore.substring(beginIndex, currentCharIndex + 1))
                        && validateParenthesisCountWithin(stringBefore.substring(beginIndex, currentCharIndex + 1));
            default:
                throw new IllegalStateException("Some unexpected char: " + chars[currentCharIndex]);
        }
    }

    private static int findCorrespondingOpening(char[] chars, char currentChar) {
        char oppositeChar = 0;

        switch (currentChar) {
            case ')':
                oppositeChar = '(';
                break;
            case '}':
                oppositeChar = '{';
                break;
            case ']':
                oppositeChar = '[';
                break;
            default:
                throw new IllegalStateException("Some unexpected char: " + currentChar);
        }
        int competitors = 0;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] == currentChar) {
                competitors++;
            } else if (chars[i] == oppositeChar) {
                if (competitors == 0) {
                    return i;
                } else {
                    competitors--;
                }
            }
        }

        throw new IllegalStateException("No corresponding opposite character found");
    }

    private static boolean validateParenthesisCountWithin(String substring) {
        char[] chars = substring.toCharArray();
        int openingCount = 0, closingCount = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    openingCount++;
                    break;
                case ')':
                    closingCount++;
                    break;
            }
        }

        return closingCount == openingCount;
    }

    private static boolean validateBracesCountWithin(String substring) {
        char[] chars = substring.toCharArray();
        int openingCount = 0, closingCount = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '{':
                    openingCount++;
                    break;
                case '}':
                    closingCount++;
                    break;
            }
        }

        return closingCount == openingCount;
    }

    private static boolean validateBracketsCountWithin(String substring) {
        char[] chars = substring.toCharArray();
        int openingCount = 0, closingCount = 0;

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '[':
                    openingCount++;
                    break;
                case ']':
                    closingCount++;
                    break;
            }
        }

        return closingCount == openingCount;
    }

    private static String extractBraces(String text) {
        return text.replaceAll("[^\\[\\](){}]", "");
    }
}
