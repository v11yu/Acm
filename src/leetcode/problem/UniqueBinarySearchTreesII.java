package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * @author v11
 */
public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res[] = new List[n+1];
		for(int i=0;i<=n;i++) res[i] = new ArrayList<TreeNode>();
		res[0].add(null);
		for(int i =1;i<=n;i++){
			for(int j=1;j<=i;j++){
				res[i].addAll(generate(new TreeNode(j),res[j-1],res[i-j],j));
			}
		}
		return res[n];
	}
	public List<TreeNode> generate(TreeNode root,List<TreeNode> left,List<TreeNode> right,int right_k){
		List<TreeNode> res = new ArrayList<TreeNode>();
		for(TreeNode l: left){
			for(TreeNode r : right){
				TreeNode node = copy(root,0);
				node.left = copy(l,0);
				node.right = copy(r,right_k);
				res.add(node);
			}
		}
		return res;
	}
	public TreeNode copy(TreeNode node,int k){
		if(node == null) return null;
		TreeNode root = new TreeNode(node.val+k);
		root.left = copy(node.left,k);
		root.right = copy(node.right,k);
		return root;
	}
}
