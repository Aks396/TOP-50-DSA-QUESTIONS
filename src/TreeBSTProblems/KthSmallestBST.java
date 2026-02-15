package TreeBSTProblems;

import java.util.Stack;

/**
 * Question 48: Kth Smallest Element in a BST
 */
public class KthSmallestBST {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println("2nd Smallest: " + kthSmallest(root, 2)); // 2
    }
}
