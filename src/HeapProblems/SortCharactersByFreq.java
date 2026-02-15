package HeapProblems;

import java.util.*;

/**
 * Question 5: Sort Characters By Frequency
 */
public class SortCharactersByFreq {
    public static String sort(String s) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char c : s.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> counts.get(b) - counts.get(a));
        pq.addAll(counts.keySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            for (int i = 0; i < counts.get(c); i++)
                sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Sorted tree: " + sort("tree")); // eert or eetr
    }
}
