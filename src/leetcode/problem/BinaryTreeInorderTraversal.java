package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

public class BinaryTreeInorderTraversal {
	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		int MAX = 10000000;
		List<Integer> res = new ArrayList<Integer>();
		TreeNode sta[] = new TreeNode[MAX];
		//init
		int top=0;
		sta[top++] = root;
		
		while(top>0){
			TreeNode now = sta[top - 1];
			if(now!=null &&now.left != null){
				sta[top++] = now.left;
				now.left = null;
				continue;
			}
			if(now != null){
				res.add(now.val); // root may be null?
			}
			top--;
			if(now!=null &&now.right != null){
				sta[top++] = now.right;
				now.right = null;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TreeNode root = TreeNode.generateTreeNode("1,4,3,2");
		new BinaryTreeInorderTraversal().inorderTraversal(root);
	}

}
