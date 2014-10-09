package leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		//int MAX = 10000000;
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> sta = new Stack<TreeNode>();
		//TreeNode sta[] = new TreeNode[MAX];
		//init
		sta.push(root);

		
		while(!sta.empty()){
			TreeNode now = sta.peek();
			if(now!=null &&now.left != null){
				sta.push(now.left);
				now.left = null;
				continue;
			}
			if(now != null){
				res.add(now.val); // root may be null?
			}
			sta.pop();
			if(now!=null &&now.right != null){
				sta.push(now.right);
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
