package LinkedListProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Question 28: Clone a Linked List with Random Pointers
 */
public class CloneListWithRandomPointer {
    static class Node {
        int val;
        Node next, random;

        Node(int v) {
            val = v;
        }
    }

    public static Node clone(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n1;

        Node copy = clone(n1);
        System.out.println("Cloned 1->2 with random links. Cloned val: " + copy.val);
    }
}
