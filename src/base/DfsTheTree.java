package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import LeetCode.extra.TreeNode;

public class DfsTheTree {

	/*
	 * 非递归实现 （1）栈S初始化；visited[n]=0； （2）访问顶点v；visited[v]=1；顶点v入栈S
	 * 
	 * （3）while(栈S非空)
	 * 
	 * x=栈S的顶元素(不出栈)；
	 * 
	 * if(找到存在并未被访问的x的邻接点w)
	 * 
	 * 访问w；visited[w]=1；
	 * 
	 * w进栈;
	 * 
	 * else
	 * 
	 * x出栈；
	 * 
	 */
	// Dfs遍历二叉树 先压栈柚子树 然后左子树
	public List<TreeNode> Dfs_tree(TreeNode root) {
		Stack<TreeNode> sta = new Stack<>();
		List<TreeNode> res = new ArrayList<>();
		if (root == null)
			return null;
		// res.add(root);
		sta.add(root);
		while (!sta.isEmpty()) {
			TreeNode temp = sta.pop();
			res.add(temp);
			if (temp.right != null)
				sta.push(temp.right);
			if (temp.left != null)
				sta.push(temp.left);
		}
		return res;

	}

}
