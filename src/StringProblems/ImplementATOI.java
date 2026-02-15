package StringProblems;

/**
 * Question 16: Implement ATOI
 * Example: Input: "42" Output: 42
 */
public class ImplementATOI {

    /**
     * Java 7 Approach: Manual parsing
     */
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty())
            return 0;
        s = s.trim();
        if (s.isEmpty())
            return 0;

        int sign = 1, index = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        long result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');
            if (result * sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            index++;
        }
        return (int) (result * sign);
    }

    /**
     * Java 8+ Approach: Using Stream API for digits
     */
    public static int myAtoiStream(String s) {
        if (s == null || s.isEmpty())
            return 0;
        s = s.trim();
        if (s.isEmpty())
            return 0;

        int sign = (s.startsWith("-")) ? -1 : 1;
        String digits = s.substring((s.startsWith("-") || s.startsWith("+")) ? 1 : 0);

        // Take while digit (Java 9+ has takeWhile, but for 8 we use a hack or just
        // manual filter)
        StringBuilder sb = new StringBuilder();
        for (char c : digits.toCharArray()) {
            if (Character.isDigit(c))
                sb.append(c);
            else
                break;
        }

        if (sb.length() == 0)
            return 0;

        try {
            java.math.BigInteger bi = new java.math.BigInteger(sb.toString())
                    .multiply(java.math.BigInteger.valueOf(sign));
            if (bi.compareTo(java.math.BigInteger.valueOf(Integer.MAX_VALUE)) > 0)
                return Integer.MAX_VALUE;
            if (bi.compareTo(java.math.BigInteger.valueOf(Integer.MIN_VALUE)) < 0)
                return Integer.MIN_VALUE;
            return bi.intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        String input = "   -42 with words";
        System.out.println("Input: '" + input + "'");
        System.out.println("Java 7: " + myAtoi(input));
        System.out.println("Java 8+: " + myAtoiStream(input));
    }
}
