package leetcode.problem;

import leetcode.model.TreeNode;
/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * @author v11
 */
public class BalancedBinaryTree {
	boolean ans = true;
	int h(TreeNode node){
		if(node == null) return 0;
		int l = h(node.left);
		int r = h(node.right);
		if( Math.abs(l-r) >1 ) ans = false; 
		return Math.max(l,r)+1;
	}
	public boolean isBalanced(TreeNode root) {
		h(root);
		return ans;
	}
}
