package TreeBSTProblems;

/**
 * Question 49: Maximum Path Sum in a Binary Tree
 */
public class MaxPathSumTree {
    private static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculate(root);
        return maxSum;
    }

    private static int calculate(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, calculate(node.left));
        int right = Math.max(0, calculate(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("Max Path Sum: " + maxPathSum(root)); // 42
    }
}
