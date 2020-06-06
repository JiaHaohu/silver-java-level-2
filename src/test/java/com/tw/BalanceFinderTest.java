package com.tw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BalanceFinderTest {
    private static Stream<Arguments> createBalancedArray() {
        //noinspection RedundantCast
        return Stream.of(
            Arguments.of((Object)new int[] {1, 1, 1, 2, 1}),
            Arguments.of((Object)new int[] {10, 10}),
            Arguments.of((Object)new int[] {10, 0, 1, -1, 10}),
            Arguments.of((Object)new int[] {1, 1, 1, 1, 4}),
            Arguments.of((Object)new int[] {1, 2, 3, 1, 0, 2, 3}),
            Arguments.of((Object)new int[] {1, 1, 1, 2, 1})
        );
    }

    private static Stream<Arguments> createUnbalancedArray() {
        //noinspection RedundantCast
        return Stream.of(
            Arguments.of((Object)new int[] {2, 1, 1, 2, 1}),
            Arguments.of((Object)new int[] {2, 1, 1, 1, 4}),
            Arguments.of((Object)new int[] {2, 3, 4, 1, 2}),
            Arguments.of((Object)new int[] {1, 2, 3, 1, 0, 1, 3}),
            Arguments.of((Object)new int[] {1})
        );
    }

    @ParameterizedTest
    @MethodSource("createBalancedArray")
    void should_return_true_if_balance(int[] balanced) {
        assertTrue(BalanceFinder.isBalanced(balanced));
    }

    @ParameterizedTest
    @MethodSource("createUnbalancedArray")
    void should_return_false_if_not_balance(int[] unbalanced) {
        assertFalse(BalanceFinder.isBalanced(unbalanced));
    }

    @Test
    void should_return_false_if_array_is_empty() {
        assertFalse(BalanceFinder.isBalanced(new int[0]));
    }
}