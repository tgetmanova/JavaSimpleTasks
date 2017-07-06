package com.github.spb.tget;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new Double[]{3d, 5d, 7d, 3d, 3.4, 12.4, 2d, 3.1})));
    }

    static <T extends Comparable<T>> T[] quickSort(T[] targetArray) {
        boolean needFurtherShifting = true;

        while (needFurtherShifting) {
            needFurtherShifting = false;
            for (int i = 0; i < targetArray.length - 1; i++) {
                if (targetArray[i].compareTo(targetArray[i + 1]) > 0) {
                    shift(targetArray, i, i + 1);
                    needFurtherShifting = true;
                    System.out.println("shifted!");
                }
            }
        }

        return targetArray;
    }

    private static <T> void shift(T[] targetArray, int preceding, int succeeding) {
        T temp = targetArray[preceding];
        targetArray[preceding] = targetArray[succeeding];
        targetArray[succeeding] = temp;
    }
}
