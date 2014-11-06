package leetcode.problem;

import leetcode.model.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return root == null?true:check(root.left,root.right);
	}

	public boolean check(TreeNode left,TreeNode right){
		if(left == null || right == null){
			if(right == left) return true;
			return false;
		}else {
			if(left.val!=right.val) return false;
		}
		return check(left.left,right.right) & check(left.right,right.left);
	}
	public static void main(String[] args) {
		TreeNode t = TreeNode.generateTreeNode("1,2,3");
		System.out.println(new SymmetricTree().isSymmetric(t));
	}
}
