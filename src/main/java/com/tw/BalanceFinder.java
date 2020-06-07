package com.tw;

import java.util.Arrays;

public class BalanceFinder {
    /**
     * <p>
     * Given an array, return true if there is a place to split the array
     * so that the sum of the numbers on one side is equal to the sum of the
     * numbers on the other side.
     * </p>
     *
     * <p>Examples:</p>
     *
     * <ul>
     *     <li>{@code isBalanced([1, 1, 1, 2, 1])} returns {@code true}</li>
     *     <li>{@code isBalanced([2, 1, 1, 2, 1])} returns {@code false}</li>
     *     <li>{@code isBalanced([10, 10])} returns {@code true}</li>
     * </ul>
     *
     * @param numbers The given array.
     * @return {@code true} if the balanced place can be found. Or else, returns
     * {@code false}.
     */
    public static boolean isBalanced(int[] numbers) {
        // TODO:
        // Please implement the method
        // <-start-
        if (numbers == null || numbers.length <= 1) {
            return false;
        }

        int sumOfNumbers = getSumOfNumbers(numbers);

        if (!isEven(sumOfNumbers)) {
            return false;
        }

        int halfOfSum = sumOfNumbers / 2;

        int cur = 0;
        for (int i = 0; i < numbers.length; i++) {
            cur += numbers[i];
            if (cur == halfOfSum) {
                return true;
            }
        }

        return false;
        // --end->
    }

    // TODO:
    // You can add additional members if you want
    // <-start-
    private static int getSumOfNumbers(int[] numbers) {
        return Arrays.stream(numbers).reduce((a, b) -> a + b).getAsInt();
    }

    private static boolean isEven(int sum) {
        return sum % 2 == 0 ? true : false;
    }
    // --end-->
}
