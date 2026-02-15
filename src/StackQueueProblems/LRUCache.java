package StackQueueProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Question 34: LRU Cache Implementation
 */
public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head, tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            add(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        add(new Node(key, value));
    }

    private void add(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("Get 1: " + cache.get(1)); // 1
        cache.put(3, 3); // removes 2
        System.out.println("Get 2: " + cache.get(2)); // -1
    }
}
