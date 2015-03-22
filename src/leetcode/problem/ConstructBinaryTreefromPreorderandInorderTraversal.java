package leetcode.problem;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author v11
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
	int findPos(int val, int[] in) {
		for(int i=0;i<in.length;i++){
			if(in[i] == val) return i;
		}
		return -1;
	}
	TreeNode buildTree(int[] pre,int pbg,int ped,int[] in,int ibg,int ied){
		
		if(pbg>ped || ibg>ied) return null;
		TreeNode node = new TreeNode(pre[pbg]);
		int p = findPos(pre[pbg],in); //in - >[ ibg , p-1], [p+1,ied]
		if(p-1 >=ibg){
			
			int leftLen = p-1-ibg;
			node.left = buildTree(pre,pbg+1,pbg+1+leftLen,in,ibg,ibg+leftLen);
			int rightLen = ied - p -1;
			node.right = buildTree(pre,ped-rightLen,ped,in,ied - rightLen,ied);
		}else{
			node.left = null;
			node.right = buildTree(pre,pbg+1,ped,in,p+1,ied);
		}
		return node;	
	}
	public TreeNode buildTree(int[] pre, int[] in) {
		int len = pre.length;
		return buildTree(pre,0,len-1,in,0,len-1);
	}
	public static void main(String[] args) {
		int pre[] = {1,2,3};
		int in[] = {3,2,1};
		TreeNode node = new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(pre, in);
		node.show(node);
	}
}
