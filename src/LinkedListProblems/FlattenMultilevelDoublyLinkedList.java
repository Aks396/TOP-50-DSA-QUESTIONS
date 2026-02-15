package LinkedListProblems;

/**
 * Question 24: Flatten a Multilevel Doubly Linked List
 */
public class FlattenMultilevelDoublyLinkedList {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int v) {
            val = v;
        }
    }

    /**
     * Java 7 Approach: Recursive DFS
     */
    public static Node flatten(Node head) {
        if (head == null)
            return null;
        Node dummy = new Node(0);
        dummy.next = head;
        flattenDFS(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }

    private static Node flattenDFS(Node prev, Node curr) {
        if (curr == null)
            return prev;
        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;
        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;
        return flattenDFS(tail, tempNext);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.prev = n1;
        n2.child = n3;

        System.out.println("Flattened list (1-2-3):");
        Node res = flatten(n1);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}
