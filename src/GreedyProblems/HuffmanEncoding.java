package GreedyProblems;

import java.util.*;

/**
 * Question 3: Huffman Encoding
 */
public class HuffmanEncoding {
    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static void encode(char[] chars, int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.freq - b.freq;
            }
        });
        for (int i = 0; i < chars.length; i++)
            pq.add(new Node(chars[i], freq[i]));
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        printCodes(pq.poll(), "");
    }

    private static void printCodes(Node root, String s) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + ": " + s);
            return;
        }
        printCodes(root.left, s + "0");
        printCodes(root.right, s + "1");
    }

    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freq = { 5, 9, 12, 13, 16, 45 };
        encode(chars, freq);
    }
}
