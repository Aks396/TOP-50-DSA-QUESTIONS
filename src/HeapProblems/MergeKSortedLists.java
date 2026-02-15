package HeapProblems;

import java.util.*;
import LinkedListProblems.ListNode;

/**
 * Question 3: Merge K Sorted Lists
 */
public class MergeKSortedLists {
    public static ListNode merge(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        for (ListNode node : lists)
            if (node != null)
                pq.add(node);
        ListNode dummy = new ListNode(0), curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null)
                pq.add(node.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(6);
        ListNode[] lists = { l1, l2 };
        ListNode res = merge(lists);
        System.out.print("Merged: ");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
