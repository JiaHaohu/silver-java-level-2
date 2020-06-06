package com.tw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NegativeReplacementTest {
    private static Stream<Arguments> createReplacementTestCases() {
        return Stream.of(
            Arguments.of("is test", "is not test"),
            Arguments.of("is-is", "is not-is not"),
            Arguments.of("This is right", "This is not right"),
            Arguments.of("This is isabell", "This is not isabell"),
            Arguments.of("", ""),
            Arguments.of("is", "is not"),
            Arguments.of("isis", "isis"),
            Arguments.of("Dis is bliss is", "Dis is not bliss is not"),
            Arguments.of("is his", "is not his"),
            Arguments.of("xis yis", "xis yis"),
            Arguments.of("AAAis is", "AAAis is not")
        );
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_return_null_if_input_is_null() {
        assertNull(NegativeReplacement.negativeReplace(null));
    }

    @ParameterizedTest
    @MethodSource("createReplacementTestCases")
    void should_return_replaced_negative_string(String originalString, String expected) {
        assertEquals(expected, NegativeReplacement.negativeReplace(originalString));
    }
}