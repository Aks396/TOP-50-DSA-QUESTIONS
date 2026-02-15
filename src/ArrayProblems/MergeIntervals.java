package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Question 3: Merge Intervals
 * Example: Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 */
public class MergeIntervals {

    /**
     * Java 7 Approach: Iterative merging
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        List<int[]> result = new ArrayList<int[]>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            if (currentInterval[1] >= nextInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                currentInterval = nextInterval;
                result.add(currentInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    /**
     * Java 8+ Approach: Using Stream API reduction
     */
    public static List<int[]> mergeStream(int[][] intervals) {
        if (intervals.length <= 1)
            return Arrays.asList(intervals);

        List<int[]> sorted = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(i -> i[0]))
                .collect(Collectors.toList());

        List<int[]> merged = sorted.stream()
                .collect(ArrayList::new, (list, interval) -> {
                    if (list.isEmpty()) {
                        list.add(interval);
                    } else {
                        int[] last = list.get(list.size() - 1);
                        if (last[1] >= interval[0]) {
                            last[1] = Math.max(last[1], interval[1]);
                        } else {
                            list.add(interval);
                        }
                    }
                }, ArrayList::addAll);

        return merged;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println("Input: [[1,3],[2,6],[8,10],[15,18]]");

        int[][] res7 = merge(intervals);
        System.out.print("Java 7 Output: ");
        for (int[] i : res7)
            System.out.print(Arrays.toString(i) + " ");
        System.out.println();

        List<int[]> res8 = mergeStream(intervals);
        System.out.print("Java 8+ Output: ");
        res8.forEach(i -> System.out.print(Arrays.toString(i) + " "));
        System.out.println();
    }
}
