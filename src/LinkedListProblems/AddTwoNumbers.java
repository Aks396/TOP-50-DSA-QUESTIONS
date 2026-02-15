package LinkedListProblems;

/**
 * Question 27: Add Two Numbers Represented by Linked Lists
 * Example: Input: 7 -> 5 -> 9, 8 -> 4 Output: 5 -> 0 -> 0 -> 1
 * (Reading as 957 + 48 = 1005? Actually usually reverse order: 243 + 564 = 807)
 * Wait, the PDF says 7->5->9 + 8->4 = 5->0->0->1.
 * Let's calculate: 957 (if interpreted as 7*1 + 5*10 + 9*100) + 48 (8*1 + 4*10)
 * = 1005.
 * So result 5->0->0->1 is 5*1 + 0*10 + 0*100 + 1*1000.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.fromArray(new int[] { 7, 5, 9 });
        ListNode l2 = ListNode.fromArray(new int[] { 8, 4 });
        System.out.print("957 + 48 = 1005 represented as ");
        addTwoNumbers(l1, l2).print();
    }
}
