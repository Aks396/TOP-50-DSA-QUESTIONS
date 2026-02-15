package HeapProblems;

import java.util.*;

/**
 * Question 7: Task Scheduler
 */
public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks)
            freq[c - 'A']++;
        Arrays.sort(freq);
        int maxVal = freq[25] - 1;
        int idleSlots = maxVal * n;
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleSlots -= Math.min(freq[i], maxVal);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        System.out.println("Time: " + leastInterval(tasks, 2)); // 8
    }
}
