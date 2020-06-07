package com.tw;

public class MirrorFinder {
    /**
     * <p>
     * Given a string, look for a mirror image (backwards) string at both the beginning
     * and end of the given string. In other words, zero or more characters at the very
     * beginning of the given string, and at the very end of the string in reverse order
     * (possibly overlapping). For example, the string "abXYZba" has the mirror end "ab".
     * </p>
     * <p>For example:</p>
     * <ul>
     *     <li>{@code findMirror("abXYZba")} returns {@code "ab"}</li>
     *     <li>{@code findMirror("abca")} returns {@code "a"}</li>
     *     <li>{@code findMirror("aba")} returns {@code "aba"}</li>
     * </ul>
     *
     * @param text The given string.
     * @return The mirror text found at beginning and end.
     */
    public static String findMirror(String text) {
        // TODO:
        // Please implement the method
        // <-start-
        if (text == null) {
            return null;
        }

        int left = 0;
        int right = text.length()-1;

        StringBuilder mirrorPart = new StringBuilder();

        while (left < text.length() && right >= 0) {

            if (text.charAt(left) == text.charAt(right)) {
                mirrorPart.append(text.charAt(left));
            } else {
                return mirrorPart.toString();
            }

            left++;
            right--;
        }

        return mirrorPart.toString();
        // --end->
    }

    // TODO:
    // You can add additional members if you want
    // <-start-

    // --end-->
}
