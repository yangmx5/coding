package hotOneHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/4/6
 */
public class TreePathSum {

    static class ListNode {
        public int value;
        public ListNode left;
        public ListNode right;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode buildTree() {
        ListNode root = new ListNode(1);
        root.left = new ListNode(2);
        root.right = new ListNode(3);
        return root;
    }

    public static void printList(List<List<ListNode>> nodeList) {
        for (List<ListNode> list : nodeList) {
            StringBuffer buffer = new StringBuffer();
            for (ListNode node : list) {
                buffer.append(node.value + ",");
            }
            System.out.println(buffer.toString());
        }
    }

    public static void main(String[] args) {
        ListNode root = buildTree();
        List<List<ListNode>> nodeRet = new ArrayList<>();
        dfs(root, nodeRet, new ArrayList<ListNode>(), 3);
        printList(nodeRet);

    }

    public static void dfs(ListNode node, List<List<ListNode>> ret, List<ListNode> nodeList, int target) {
        if (target == 0) {
            ret.add(new ArrayList<>(nodeList));
        }
        if (node == null || target < 0) {
            return;
        }
        nodeList.add(node);
        dfs(node.left, ret, nodeList, target - node.value);
        dfs(node.right, ret, nodeList, target - node.value);
        nodeList.remove(nodeList.size() - 1);
    }
}
