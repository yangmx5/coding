package hotBack;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author fouthed
 * @date 2023/6/14
 */
public class TreeToList {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static Queue<TreeNode> q = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            tmp.left = null;
            tmp.right = q.peek();
        }

        printTree(root);

    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        q.offer(root);
        dfs(root.left);
        dfs(root.right);
    }


}
