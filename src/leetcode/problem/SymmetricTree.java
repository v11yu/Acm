package leetcode.problem;

import leetcode.model.TreeNode;

public class SymmetricTree {
	private static String str =""; 
	public boolean isSymmetric(TreeNode root) {
		second(root);
		return check(str);
	}
	public void second(TreeNode root){
		if(root == null) return ;
		second(root.left);
		str+=root.val;
		second(root.right);
	}
	public boolean check(String str){
		for(int i=0;i<str.length();i++){
    		if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
    	}
		return true;
	}
	public static void main(String[] args) {
		TreeNode t = TreeNode.generateTreeNode("1,2");
		System.out.println(new SymmetricTree().isSymmetric(t));
	}
}
