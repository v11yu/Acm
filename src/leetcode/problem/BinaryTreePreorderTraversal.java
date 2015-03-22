package leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.model.TreeNode;
/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * @author v11
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode it = root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		if(it!=null) st.add(it);
		while(st.size()>0){
			it = st.pop();
			if(it.right!=null) st.add(it.right);
			if(it.left !=null) st.add(it.left);
			res.add(it.val);
		}
		return res;
	}
}
