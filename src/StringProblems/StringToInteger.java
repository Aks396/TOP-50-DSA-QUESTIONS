package StringProblems;

/**
 * Question 17: String to Integer Conversion
 * Example: Input: "-123" Output: -123
 */
public class StringToInteger {

    /**
     * Java 7 Approach: Simple parsing
     */
    public static int convert(String s) {
        return Integer.parseInt(s);
    }

    /**
     * Java 8+ Approach: Using Optional/Functional style for safety
     */
    public static int convertStream(String s) {
        return java.util.Optional.ofNullable(s)
                .map(String::trim)
                .map(Integer::valueOf)
                .orElse(0);
    }

    public static void main(String[] args) {
        String input = "-123";
        System.out.println("Input: " + input);
        System.out.println("Java 7: " + convert(input));
        System.out.println("Java 8+: " + convertStream(input));
    }
}
