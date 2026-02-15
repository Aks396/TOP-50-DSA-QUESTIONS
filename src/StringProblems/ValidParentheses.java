package StringProblems;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Question 15: Check for Valid Parentheses
 * Example: Input: "()[]{}" Output: true
 */
public class ValidParentheses {

    /**
     * Java 7 Approach: Using Stack
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    /**
     * Java 8+ Approach: Streams aren't well-suited for stack-based grammar,
     * but we can use reduce to simulate a state.
     */
    public static boolean isValidStream(String s) {
        // Simulating stack with a string/builder in reduction
        try {
            return s.chars().boxed()
                    .reduce("", (stack, c_int) -> {
                        char c = (char) c_int.intValue();
                        if (c == '(')
                            return stack + ")";
                        if (c == '{')
                            return stack + "}";
                        if (c == '[')
                            return stack + "]";
                        if (stack.isEmpty() || stack.charAt(stack.length() - 1) != c)
                            throw new RuntimeException();
                        return stack.substring(0, stack.length() - 1);
                    }, (s1, s2) -> s1 + s2).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String input = "()[]{}";
        System.out.println("Input: " + input);
        System.out.println("Java 7: " + isValid(input));
        System.out.println("Java 8+: " + isValidStream(input));
    }
}
