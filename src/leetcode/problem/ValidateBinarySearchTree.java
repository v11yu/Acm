package leetcode.problem;

import leetcode.model.TreeNode;



public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	private boolean dfs(TreeNode root,int Min,int Max){
		if(root == null) 
			return true;
		if(dfs(root.left,Min,root.val) &&
				dfs(root.right,root.val,Max)&&
				root.val>Min&&root.val<Max){
			return true;
		}
		return false;
	}
}
