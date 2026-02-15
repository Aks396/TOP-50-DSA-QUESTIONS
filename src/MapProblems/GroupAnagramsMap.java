package MapProblems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Question 9: Group Anagrams (Revised HashMap approach)
 */
public class GroupAnagramsMap {
    public static List<List<String>> group(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

    /**
     * Java 8+ Approach
     */
    public static List<List<String>> groupStream(String[] strs) {
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] arr = s.toCharArray();
                    Arrays.sort(arr);
                    return new String(arr);
                }))
                .values().stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println("Java 7: " + group(strs));
        System.out.println("Java 8: " + groupStream(strs));
    }
}
