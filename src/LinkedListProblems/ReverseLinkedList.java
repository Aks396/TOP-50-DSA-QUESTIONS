package LinkedListProblems;

/**
 * Question 21: Reverse a Linked List
 * Example: Input: 1 -> 2 -> 3 -> 4 -> 5 Output: 5 -> 4 -> 3 -> 2 -> 1
 */
public class ReverseLinkedList {

    /**
     * Java 7 Approach: Iterative reversal
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * Java 8+ Approach: Streams are not natural for linked lists,
     * but we can use recursion or stack-like reduction.
     */
    public static ListNode reverseStream(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseStream(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5 };
        System.out.print("Input: ");
        ListNode.fromArray(data).print();

        System.out.print("Java 7 Reverted: ");
        reverse(ListNode.fromArray(data)).print();

        System.out.print("Java 8+ Reverted: ");
        reverseStream(ListNode.fromArray(data)).print();
    }
}
