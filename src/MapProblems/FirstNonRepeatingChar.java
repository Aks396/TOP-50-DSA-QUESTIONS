package MapProblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Question 3: First Non-Repeating Character
 */
public class FirstNonRepeatingChar {
    public static char find(String s) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char c : s.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        for (char c : s.toCharArray())
            if (counts.get(c) == 1)
                return c;
        return '_';
    }

    /**
     * Java 8+ Approach
     */
    public static char findStream(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .map(e -> e.getKey())
                .findFirst()
                .orElse('_');
    }

    public static void main(String[] args) {
        System.out.println("Java 7: " + find("leetcode")); // l
        System.out.println("Java 8: " + findStream("leetcode")); // l
    }
}
