package TreeBSTProblems;

import java.util.*;

/**
 * Question 47: Zigzag Level Order Traversal
 */
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> currentLevel = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (reverse)
                    currentLevel.addFirst(node.val);
                else
                    currentLevel.addLast(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            res.add(currentLevel);
            reverse = !reverse;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        System.out.println("Zigzag: " + zigzagLevelOrder(root));
    }
}
