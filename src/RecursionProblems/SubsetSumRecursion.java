package RecursionProblems;

/**
 * Question 8: Subset Sum Problem (Check if a subset exists)
 */
public class SubsetSumRecursion {
    public static boolean isSum(int[] arr, int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (arr[n - 1] > sum)
            return isSum(arr, n - 1, sum);
        return isSum(arr, n - 1, sum) || isSum(arr, n - 1, sum - arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 34, 4, 12, 5, 2 };
        System.out.println("Has Sum 9: " + isSum(arr, arr.length, 9)); // true
    }
}
