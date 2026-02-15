package TreeBSTProblems;

/**
 * Question 44: Lowest Common Ancestor in a Binary Tree
 */
public class LowestCommonAncestorTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        root.left = p;
        root.right = q;
        System.out.println("LCA: " + lowestCommonAncestor(root, p, q).val); // 3
    }
}
