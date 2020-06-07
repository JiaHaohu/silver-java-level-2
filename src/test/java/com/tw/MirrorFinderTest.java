package com.tw;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MirrorFinderTest {
    private static Stream<Arguments> createMirrorTestCases() {
        return Stream.of(
            Arguments.of("abXYZba", "ab"),
            Arguments.of("abca", "a"),
            Arguments.of("aba", "aba"),
            Arguments.of("abab", ""),
            Arguments.of("xxx", "xxx"),
            Arguments.of("xxYxx", "xxYxx"),
            Arguments.of("Hi and iH", "Hi "),
            Arguments.of("x", "x"),
            Arguments.of("", ""),
            Arguments.of("123and then 321", "123"),
            Arguments.of("band andab", "ba")
        );
    }

    @Test
    void should_return_null_if_string_is_null() {
        assertNull(MirrorFinder.findMirror(null));
    }

    @ParameterizedTest
    @MethodSource("createMirrorTestCases")
    void should_return_mirrored_text(String text, String expected) {
        assertEquals(expected, MirrorFinder.findMirror(text));
    }

    @Test
    void match(){
        String str =" is is aaa";

        System.out.println(str.indexOf(" is",4));

    }
}