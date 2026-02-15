package RecursionProblems;

/**
 * Question 4: Reverse String using Recursion
 */
public class ReverseStringRecursion {
    public static void reverse(char[] s, int l, int r) {
        if (l >= r)
            return;
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        reverse(s, l + 1, r - 1);
    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        reverse(s, 0, s.length - 1);
        System.out.println("Reversed: " + new String(s));
    }
}
