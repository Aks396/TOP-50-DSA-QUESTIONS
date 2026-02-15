package LinkedListProblems;

/**
 * Question 23: Merge Two Sorted Linked Lists
 * Example: Input: 1 -> 2 -> 4, 1 -> 3 -> 4 Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
 */
public class MergeTwoSortedLists {

    /**
     * Java 7 Approach: Iterative merge
     */
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
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

    /**
     * Java 8+ Approach: Recursive
     */
    public static ListNode mergeRecursive(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val < l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[] { 1, 2, 4 });
        ListNode l2 = ListNode.fromArray(new int[] { 1, 3, 4 });

        System.out.print("L1: ");
        l1.print();
        System.out.print("L2: ");
        l2.print();

        System.out.print("Merged: ");
        merge(ListNode.fromArray(new int[] { 1, 2, 4 }), ListNode.fromArray(new int[] { 1, 3, 4 })).print();
    }
}
