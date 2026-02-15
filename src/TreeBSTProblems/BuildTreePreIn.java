package TreeBSTProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Question 50: Construct a Binary Tree from Preorder and Inorder Traversal
 */
public class BuildTreePreIn {
    private static int preIndex = 0;
    private static Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inMap.clear();
        for (int i = 0; i < inorder.length; i++)
            inMap.put(inorder[i], i);
        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        int val = preorder[preIndex++];
        TreeNode node = new TreeNode(val);
        node.left = build(preorder, left, inMap.get(val) - 1);
        node.right = build(preorder, inMap.get(val) + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Root: " + root.val);
    }
}
