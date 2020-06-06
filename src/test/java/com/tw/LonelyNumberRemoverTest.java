package com.tw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LonelyNumberRemoverTest {
    @Test
    void should_return_null_if_input_array_is_null() {
        final int notImportant = 0;
        assertNull(LonelyNumberRemover.removeLonelyNumber(null, notImportant));
    }

    @Test
    void should_return_original_array_if_there_is_only_1_or_2_elements() {
        assertArrayEquals(
            new int[] {1},
            LonelyNumberRemover.removeLonelyNumber(new int[] {1}, 1)
        );
        assertArrayEquals(
            new int[] {1, 2},
            LonelyNumberRemover.removeLonelyNumber(new int[] {1, 2}, 1)
        );
    }

    static Stream<Arguments> createLonelyNumberTestCases() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3}, 2, new int[] {1, 3, 3} ),
            Arguments.of(new int[] {1, 2, 3, 2, 5, 2}, 2, new int[] {1, 3, 3, 5, 5, 2} ),
            Arguments.of(new int[] {1, 3, 1, 2}, 1, new int[] {1, 3, 3, 2} ),
            Arguments.of(new int[] {7, 1, 6}, 1, new int[] {7, 7, 6} ),
            Arguments.of(new int[] {1, 1, 1}, 1, new int[] {1, 1, 1} ),
            Arguments.of(new int[] {1, 1, 1, 2}, 1, new int[] {1, 1, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource({"createLonelyNumberTestCases"})
    void should_remove_lonely_numbers(int[] original, int target, int[] expected) {
        assertArrayEquals(
            expected,
            LonelyNumberRemover.removeLonelyNumber(original, target)
        );
    }

    @Test
    void should_not_change_the_original_array() {
        int[] original = {7, 1, 6};
        LonelyNumberRemover.removeLonelyNumber(original, 1);
        assertArrayEquals(
            new int[] {7, 1, 6},
            original
        );
    }
}