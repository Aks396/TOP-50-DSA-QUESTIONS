package StringProblems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Question 14: Group Anagrams
 * Example: Input: ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {

    /**
     * Java 7 Approach: Using HashMap with sorted keys
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * Java 8+ Approach: Using Stream API groupingBy
     */
    public static List<List<String>> groupAnagramsStream(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] ca = s.toCharArray();
                    Arrays.sort(ca);
                    return String.valueOf(ca);
                }))
                .values().stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Java 7: " + groupAnagrams(input));
        System.out.println("Java 8+: " + groupAnagramsStream(input));
    }
}
