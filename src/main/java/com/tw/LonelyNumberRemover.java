package com.tw;

public class LonelyNumberRemover {

    /**
     * <p>
     * We'll say that an element in an array is "alone" if there are values before and after it,
     * and those values are different from it. Return a version of the given array where every
     * instance of the given value which is alone is replaced by whichever value to its left or
     * right is larger.
     * </p>
     *
     * <p>Examples:</p>
     * <ul>
     *     <li>{@code removeLonelyNumber([1, 2, 3], 2)} returns {@code [1, 3, 3]}</li>
     *     <li>{@code removeLonelyNumber(1, 2, 3, 2, 5, 2], 2)} returns {@code [1, 3, 3, 5, 5, 2]}</li>
     *     <li>{@code removeLonelyNumber([3, 4], 3)} returns {@code [3, 4]}</li>
     * </ul>
     *
     * @param numbers     The given number array.
     * @param targetValue Then given value.
     * @return The processed array.
     */
    public static int[] removeLonelyNumber(int[] numbers, int targetValue) {
        // TODO:
        // Please implement the method
        // <-start-
        if (numbers == null) {
            return null;
        }

        if (numbers.length <= 2) {
            return numbers;
        }

        int[] result = numbers.clone();

        for (int i = 1; i < numbers.length - 1; i++) {
            if (numbers[i] == targetValue) {
                replaceLonelyNumber(i, result);
            }
        }

        return result;
        // --end->
    }

    // TODO:
    // You can add additional members if you want
    // <-start-
    private static void replaceLonelyNumber(int i, int[] numbers) {
        if (numbers[i] != numbers[i - 1] && numbers[i] != numbers[i + 1]) {
            numbers[i] = Math.max(numbers[i - 1], numbers[i + 1]);
        }
    }

    // --end-->
}
