package StringProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Question 12: Reverse Words in a String
 * Example: Input: "the sky is blue" Output: "blue is sky the"
 */
public class ReverseWords {

    /**
     * Java 7 Approach: Split, reverse, and join
     */
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0)
                sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * Java 8+ Approach: Using Stream API
     */
    public static String reverseWordsStream(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return words.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        System.out.println("Input: '" + input + "'");
        System.out.println("Java 7: '" + reverseWords(input) + "'");
        System.out.println("Java 8+: '" + reverseWordsStream(input) + "'");
    }
}
