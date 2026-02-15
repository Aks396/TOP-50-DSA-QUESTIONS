package TreeBSTProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 41: Inorder, Preorder, Postorder Traversals
 */
public class TreeTraversals {

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    public static void postorder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        System.out.println("Inorder: " + res);
    }
}
