package leetcode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * https://oj.leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * @author v11
 */

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<>();
		if(root!=null)st.add(root);
		while(st.size() > 0){
			TreeNode e = st.pop();
			TreeNode tmp = new TreeNode(e.val);
			tmp.left = root; // mark used to print
			if(e.left == root) res.add(e.val);
			else{
			    st.add(tmp);
				if(e.right!=null) st.add(e.right);
				if(e.left!=null) st.add(e.left);
			}
		}
		return res;
	}
}
