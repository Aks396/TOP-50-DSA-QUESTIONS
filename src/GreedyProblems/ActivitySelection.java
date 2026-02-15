package GreedyProblems;

import java.util.*;

/**
 * Question 1: Activity Selection Problem
 */
public class ActivitySelection {
    static class Activity {
        int start, finish;

        Activity(int s, int f) {
            start = s;
            finish = f;
        }
    }

    public static void selectActivities(int[] s, int[] f) {
        int n = s.length;
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++)
            activities[i] = new Activity(s[i], f[i]);

        Arrays.sort(activities, new Comparator<Activity>() {
            public int compare(Activity a, Activity b) {
                return a.finish - b.finish;
            }
        });

        System.out.print("Selected Activities: ");
        int i = 0;
        System.out.print("(" + activities[i].start + ", " + activities[i].finish + ") ");
        for (int j = 1; j < n; j++) {
            if (activities[j].start >= activities[i].finish) {
                System.out.print("(" + activities[j].start + ", " + activities[j].finish + ") ");
                i = j;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };
        selectActivities(start, finish);
    }
}
