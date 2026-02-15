package LinkedListProblems;

/**
 * Question 29: Sort a Linked List
 * Example: Input: 4 -> 2 -> 1 -> 3 Output: 1 -> 2 -> 3 -> 4
 */
public class SortLinkedList {

    /**
     * Java 7 Approach: Merge Sort on Linked List
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[] { 4, 2, 1, 3 });
        System.out.print("Unsorted: ");
        head.print();
        System.out.print("Sorted: ");
        sortList(head).print();
    }
}
