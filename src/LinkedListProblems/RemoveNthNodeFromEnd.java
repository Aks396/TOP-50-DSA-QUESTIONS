package LinkedListProblems;

/**
 * Question 26: Remove N-th Node from the End of the List
 * Example: Input: 1 -> 2 -> 3 -> 4 -> 5, n = 2 Output: 1 -> 2 -> 3 -> 5
 */
public class RemoveNthNodeFromEnd {

    /**
     * Java 7 Approach: Fast and Slow pointers
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i <= n + 1; i++)
            first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[] { 1, 2, 3, 4, 5 });
        System.out.print("Original: ");
        head.print();
        System.out.print("After removing 2nd from end: ");
        removeNthFromEnd(head, 2).print();
    }
}
