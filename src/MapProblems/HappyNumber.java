package MapProblems;

import java.util.*;

/**
 * Question 6: Happy Number
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<Integer>();
        while (n != 1 && !visited.contains(n)) {
            visited.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Is 19 happy: " + isHappy(19)); // true
    }
}
