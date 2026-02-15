package MapProblems;

import java.util.*;

/**
 * Question 4: Intersection of Two Arrays
 */
public class IntersectionTwoArrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int n : nums1)
            set1.add(n);
        Set<Integer> res = new HashSet<Integer>();
        for (int n : nums2)
            if (set1.contains(n))
                res.add(n);

        int[] result = new int[res.size()];
        int i = 0;
        for (int n : res)
            result[i++] = n;
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = { 1, 2, 2, 1 }, n2 = { 2, 2 };
        System.out.println("Intersection: " + Arrays.toString(intersect(n1, n2))); // [2]
    }
}
