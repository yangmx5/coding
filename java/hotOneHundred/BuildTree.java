package hotOneHundred;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fouthed
 * @date 2023/5/8
 */
public class BuildTree {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public Integer value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static Map<Integer, Integer> midMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] midorder = new int[]{9, 3, 15, 20, 7};
        for (int i = 0; i < midorder.length; i++) {
            midMap.put(midorder[i], i);
        }

        TreeNode root = buildTree(preorder, midorder, 0, preorder.length - 1, 0, midorder.length - 1);
        printTree(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] midorder,
                                     int prel, int prer,
                                     int midl, int midr) {
        if (prel > prer) {
            return null;
        }
        int rootValue = preorder[prel];
        TreeNode root = new TreeNode(rootValue);

        int midIndex = midMap.get(rootValue);
        int length = midIndex - midl;

        root.left = buildTree(preorder, midorder, prel + 1, prel + length, midl, midIndex - 1);
        root.right = buildTree(preorder, midorder, prel + length + 1, prer, midIndex + 1, midr);
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        printTree(root.left);
        printTree(root.right);
    }
}
