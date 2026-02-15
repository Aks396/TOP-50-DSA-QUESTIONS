package RecursionProblems;

/**
 * Question 2: Sum of Digits
 * Example: 123 -> 6
 */
public class SumOfDigits {
    public static int sum(int n) {
        if (n == 0)
            return 0;
        return (n % 10) + sum(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("Sum of 1234: " + sum(1234)); // 10
    }
}
