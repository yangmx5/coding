package hotOneHundred.dp;

import base.BlockingQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author fouthed
 * @date 2023/4/11
 */
public class CashRobThree {

    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{3, 4, 5, 1, 3, null, 1};
        Integer[] nums = new Integer[]{3, 2, 3, null, 3, null, 1};
        TreeNode root = buildTree(nums);
        System.out.println(resolve(root));

    }

    static class TreeNode {
        public Integer value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }

    public static TreeNode buildTree(Integer[] nums) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int n = 0; n < size; n++) {
                TreeNode tmp = queue.poll();
                if (i < nums.length) {
                    tmp.left = new TreeNode(nums[i++]);
                    queue.offer(tmp.left);
                }

                if (i < nums.length) {
                    tmp.right = new TreeNode(nums[i++]);
                    queue.offer(tmp.right);
                }
            }
        }
        return root;
    }

    static Map<TreeNode, Integer> f = new HashMap<>();
    static Map<TreeNode, Integer> g = new HashMap<>();

    public static Integer resolve(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));

    }

    public static void dfs(TreeNode root) {
        if (root == null || root.value == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        f.put(root, root.value + g.getOrDefault(root.left, 0) + g.getOrDefault(root.right, 0));
        g.put(root, Math.max(f.getOrDefault(root.left, 0),
                g.getOrDefault(root.left, 0)) + Math.max(f.getOrDefault(root.right, 0),
                g.getOrDefault(root.right, 0))
        );
    }
}
