package SearchSortProblems;

import java.util.Arrays;

/**
 * Question 10: Radix Sort
 */
public class RadixSort {
    public static void sort(int[] arr) {
        if (arr.length == 0)
            return;
        int m = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };
        sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}
