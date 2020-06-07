package com.tw;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NegativeReplacement {
    /**
     * <p>
     * Given a string (with only English letters, whitespace characters and
     * punctuations on the keyboard), return a string where every appearance
     * of the lowercase word "is" has been replaced with "is not". The word
     * "is" should not be immediately proceeded or followed by an English
     * character -- so for example the "is" in "this" does not count.
     * </p>
     *
     * <p>Example:</p>
     *
     * <ul>
     *     <li>{@code negativeReplace("is test")} is {@code "is not test"}</li>
     *     <li>{@code negativeReplace("is-is")} is {@code "is not-is not"}</li>
     *     <li>{@code negativeReplace("This is right")} is {@code "This is not right"}</li>
     * </ul>
     *
     * @param text The given string.
     * @return The replaced string.
     */
    public static String negativeReplace(String text) {
        // TODO:
        // Please implement the method
        // <-start-
        if (text == null) {
            return null;
        }


        List<Integer> indexOfIs = getIndexOfIs(text);

        String result = replaceIs(indexOfIs,text);

        return result;
        // --end->
    }

    private static String replaceIs(List<Integer> indexOfIs, String text) {
        String partOfNot = " not";
        StringBuilder result = new StringBuilder();
        int preIndex = 0;
        for (Integer index : indexOfIs) {
            result.append(text.substring(preIndex,index+2));
            result.append(partOfNot);
            preIndex = index+2;
        }
        if (preIndex < text.length()){
            result.append(text.substring(preIndex,text.length()));
        }
        return result.toString();
    }


    // TODO:
    // You can add additional members if you want
    // <-start-
    private static List<Integer> getIndexOfIs(String text) {
        int fromIndex = 0;
        String match = "\\bis\\b";

        List<Integer> indexList = new ArrayList<>();

        Pattern compile = Pattern.compile(match);
        Matcher matcher = compile.matcher(text);

        while (matcher.find()){
            indexList.add(matcher.start());
        }


        return indexList;
    }
    // --end-->
}
