package TreeBSTProblems;

/**
 * Question 45: Validate a Binary Search Tree
 */
public class ValidateBST {
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null)
            return true;
        if ((low != null && node.val <= low) || (high != null && node.val >= high))
            return false;
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Is Valid BST: " + isValidBST(root)); // true
    }
}
