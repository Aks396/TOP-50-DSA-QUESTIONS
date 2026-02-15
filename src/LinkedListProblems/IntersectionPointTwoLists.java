package LinkedListProblems;

/**
 * Question 25: Find the Intersection Point of Two Linked Lists
 * Example: List A: 4 -> 1 -> 8 -> 4 -> 5, List B: 5 -> 0 -> 1 -> 8 -> 4 -> 5
 * Output: 8
 */
public class IntersectionPointTwoLists {

    /**
     * Java 7 Approach: Two pointers switching lists
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a; // Meeting point is intersection
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = common;

        ListNode b = new ListNode(5);
        b.next = new ListNode(0);
        b.next.next = new ListNode(1);
        b.next.next.next = common;

        ListNode result = getIntersectionNode(a, b);
        System.out.println("Intersection at: " + (result != null ? result.val : "null"));
    }
}
