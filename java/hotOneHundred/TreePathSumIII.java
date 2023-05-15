package hotOneHundred;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author fouthed
 * @date 2023/5/15
 */
public class TreePathSumIII {

    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public Integer value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        Map<Long, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0L, 1);
        int targetNum = 1;
        System.out.println(dfs(root, prefixMap, 0L, targetNum));
    }

    public static long dfs(TreeNode root, Map<Long, Integer> prefixMap, Long curr, Integer targetNum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        curr += root.value;
        ret = prefixMap.getOrDefault(curr - targetNum, 0);
        prefixMap.put(curr, prefixMap.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefixMap, curr, targetNum);
        ret += dfs(root.right, prefixMap, curr, targetNum);
        prefixMap.put(curr, prefixMap.getOrDefault(curr, 0) - 1);
        return ret;
    }
}
