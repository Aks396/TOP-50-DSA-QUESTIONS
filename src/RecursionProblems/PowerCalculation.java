package RecursionProblems;

/**
 * Question 3: Power Calculation (x^n)
 */
public class PowerCalculation {
    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1 / myPow(x, -n);
        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        return half * half * x;
    }

    public static void main(String[] args) {
        System.out.println("2^10: " + myPow(2, 10)); // 1024.0
    }
}
