package forwardoffer;

import java.util.Arrays;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

/*
 * 根据前序遍历 和中序遍历重建二叉树
 */
public class RebuildTree {

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0)
			return null;
		TreeNode node = new TreeNode(pre[0]);
		for (int i = 0; i < in.length; i++) {
			if (pre[0] == in[i]) {
				node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
				node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(pre, i + 1, in.length));
			}
		}
		return node;
	}

	public static void main(String[] args) {

	}
}
