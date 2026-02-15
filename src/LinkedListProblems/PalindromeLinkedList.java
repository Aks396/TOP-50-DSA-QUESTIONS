package LinkedListProblems;

import java.util.Stack;

/**
 * Question 30: Check if a Linked List is Palindrome
 * Example: Input: 1 -> 2 -> 2 -> 1 Output: true
 */
public class PalindromeLinkedList {

    /**
     * Java 7 Approach: Use Stack
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            slow = slow.next; // Odd length
        while (slow != null) {
            if (stack.pop() != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[] { 1, 2, 2, 1 });
        System.out.print("1->2->2->1 is palindrome: " + isPalindrome(head));
    }
}
