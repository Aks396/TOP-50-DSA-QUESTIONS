package StringProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Question 20: Minimum Window Substring
 * Example: Input: s = "ADOBECODEBANC", t = "ABC" Output: "BANC"
 */
public class MinimumWindowSubstring {

    /**
     * Java 7 Approach: Sliding Window with two maps
     */
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = dictT.containsKey(c) ? dictT.get(c) : 0;
            dictT.put(c, count + 1);
        }

        int required = dictT.size();
        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = { -1, 0, 0 }; // length, left, right

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.containsKey(c) ? windowCounts.get(c) : 0;
            windowCounts.put(c, count + 1);
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    /**
     * Java 8+ Approach: Logic remains sliding window, wrapping it.
     */
    public static String minWindowStream(String s, String t) {
        return minWindow(s, t);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println("s: " + s + ", t: " + t);
        System.out.println("Java 7 result: " + minWindow(s, t));
        System.out.println("Java 8+ result: " + minWindowStream(s, t));
    }
}
