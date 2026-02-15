package HeapProblems;

import java.util.*;

/**
 * Question 10: Reorganize String (No Two Adjacent Characters are same)
 */
public class ReorganizeString {
    public static String reorganize(String s) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char c : s.toCharArray())
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue<Character>((a, b) -> counts.get(b) - counts.get(a));
        pq.addAll(counts.keySet());

        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            char c1 = pq.poll();
            char c2 = pq.poll();
            sb.append(c1).append(c2);
            if (counts.put(c1, counts.get(c1) - 1) > 1)
                pq.add(c1);
            if (counts.put(c2, counts.get(c2) - 1) > 1)
                pq.add(c2);
        }
        if (!pq.isEmpty()) {
            char last = pq.poll();
            if (counts.get(last) > 1)
                return "";
            sb.append(last);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Result aab: " + reorganize("aab")); // aba
        System.out.println("Result aaab: " + reorganize("aaab")); // ""
    }
}
