package hotBack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fouthed
 * @date 2023/6/14
 *
 *根据中序遍历和先序遍历构造二叉树
 */
public class BuildTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static Map<Integer, Integer> inMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        printTree(root.left);
        printTree(root.right);
        System.out.println(root.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int prel, int prer, int inl, int inr) {
        if (prel > prer) {
            return null;
        }
        int rootVal = preorder[prel];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inMap.get(rootVal);

        int leftLen = inRootIndex - inl;
        int rightLen = inr - inRootIndex;
        root.left = buildTree(preorder, inorder, prel + 1, prel + leftLen , inl, inRootIndex - 1);
        root.right = buildTree(preorder, inorder, prel + leftLen + 1, prer, inRootIndex + 1, inr);
        return root;
    }

}
