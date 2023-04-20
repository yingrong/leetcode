package org.example.array_and_string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GcdOfStringTest {

    static Stream<Arguments> stringPairProvider() {

        return Stream.of(
                Arguments.of("ABC", "ABCABC", "ABC"),
                Arguments.of("ABCABC", "ABCABCABCABC", "ABCABC"),
                Arguments.of("ABC", "ABCABCD", "")
        );
    }

    @ParameterizedTest
    @MethodSource("stringPairProvider")
    void gcdOfString(String str1, String str2, String gcdString) {
        assertEquals(gcdString, new GcdOfString().gcdOfStrings1(str1, str2));
    }
}