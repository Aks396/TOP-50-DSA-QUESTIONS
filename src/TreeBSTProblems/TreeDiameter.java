package TreeBSTProblems;

/**
 * Question 43: Diameter of a Binary Tree
 */
public class TreeDiameter {
    private static int maxDiameter = 0;

    public static int diameter(TreeNode root) {
        maxDiameter = 0;
        depth(root);
        return maxDiameter;
    }

    private static int depth(TreeNode root) {
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Diameter: " + diameter(root)); // 3
    }
}
