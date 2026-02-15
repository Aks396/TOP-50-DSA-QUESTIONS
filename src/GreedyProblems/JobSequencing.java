package GreedyProblems;

import java.util.*;

/**
 * Question 6: Job Sequencing Problem
 */
public class JobSequencing {
    static class Job {
        char id;
        int d, p;

        Job(char id, int d, int p) {
            this.id = id;
            this.d = d;
            this.p = p;
        }
    }

    public static void sequence(Job[] jobs, int n) {
        Arrays.sort(jobs, (a, b) -> b.p - a.p);
        boolean[] result = new boolean[n];
        char[] jobList = new char[n];
        for (int i = 0; i < jobs.length; i++) {
            for (int j = Math.min(n, jobs[i].d) - 1; j >= 0; j--) {
                if (!result[j]) {
                    result[j] = true;
                    jobList[j] = jobs[i].id;
                    break;
                }
            }
        }
        for (char c : jobList)
            if (c != 0)
                System.out.print(c + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Job[] jobs = { new Job('a', 2, 100), new Job('b', 1, 19), new Job('c', 2, 27), new Job('d', 1, 25),
                new Job('e', 3, 15) };
        sequence(jobs, 3);
    }
}
