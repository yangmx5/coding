package hotOneHundred;

import hotOneHundred.dp.CashRobThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fouthed
 * @date 2023/4/11
 */
public class TreeForeach {

    static class TreeNode {
        public Integer value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Integer value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Integer[] nums = new Integer[]{2, null, 43, 54, 1, 2};
        TreeNode root1 = buildTree(nums);

        printTree(root1);


    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp != null) {
                queue.add(tmp.left);
                queue.add(tmp.right);
                ret.add(tmp.value);
            } else {
                ret.add(null);
            }
        }
        System.out.println(Arrays.toString(ret.toArray()));
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
}
