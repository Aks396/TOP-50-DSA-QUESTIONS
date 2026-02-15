package LinkedListProblems;

/**
 * Question 22: Detect and Remove a Loop in a Linked List
 * Example: Input: Linked List with a loop Output: Loop removed
 */
public class DetectAndRemoveLoop {

    /**
     * Java 7 Approach: Floyd's Cycle-Finding Algorithm
     */
    public static void detectAndRemove(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow, head);
                return;
            }
        }
    }

    private static void removeLoop(ListNode loopNode, ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = loopNode;

        // Count nodes in loop
        int k = 1;
        while (ptr2.next != loopNode) {
            ptr2 = ptr2.next;
            k++;
        }

        // Set one ptr at head, another at k distance from head
        ptr1 = head;
        ptr2 = head;
        for (int i = 0; i < k; i++)
            ptr2 = ptr2.next;

        // Move both at same pace, they meet at loop start
        while (ptr2 != ptr1) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Find last node
        while (ptr2.next != ptr1)
            ptr2 = ptr2.next;
        ptr2.next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // Loop at 2

        System.out.println("Loop detected and removed.");
        detectAndRemove(head);
        head.print();
    }
}
