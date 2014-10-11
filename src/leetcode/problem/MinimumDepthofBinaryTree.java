package leetcode.problem;

import java.util.*;

import leetcode.model.TreeNode;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		int ans = 0;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		if(root == null) return 0;
		root.val = 1;
		que.offer(root);
		while(!que.isEmpty()){
			TreeNode t = que.poll();
			if(t.left == null && t.right ==null){
				return t.val;
			}
			if(t.left!=null){
				t.left.val = t.val + 1;
				que.offer(t.left);
			}
			if(t.right!=null){
				t.right.val = t.val + 1;
				que.offer(t.right);
			}
		}
		return ans;
	}
}
