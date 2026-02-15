package TreeBSTProblems;

import java.util.*;

/**
 * Question 46: Serialize and Deserialize a Binary Tree
 */
public class SerializeDeserializeTree {
    public static String serialize(TreeNode root) {
        if (root == null)
            return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<String>(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }

    private static TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if ("null".equals(val))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        String s = serialize(root);
        System.out.println("Serialized: " + s);
        TreeNode d = deserialize(s);
        System.out.println("Deserialized root: " + d.val);
    }
}
