package leetcode.model;

public class TreeNode {
	public static int MAX = 10000000;
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	public TreeNode() {}
	/**
	 * generated TreeNode by String
	 * @param s : "1,#,2,3"
	 */
	public static TreeNode generateTreeNode(String s){
		TreeNode root = new TreeNode();
		String ls[] = s.split(",");
		if(ls[0].compareTo("#") == 0){
			root = null;
		}
		else {
			root.val = Integer.parseInt(ls[0]);
		}
		TreeNode que[] = new TreeNode[MAX];
		int top=0,end=0;
		que[end++] = root;
		int j = 0;
		while(top<end){
			TreeNode now = que[top++];
			if(now == null)
				continue;
			if(j+1 < ls.length){
				if (ls[j + 1].compareTo("#") == 0) {
					now.left = null;
				} else {
					TreeNode l = new TreeNode();
					l.val = Integer.parseInt(ls[j + 1]);
					now.left = l;
				}
				j++;
			}
			if(j+1 < ls.length){
				if (ls[j + 1].compareTo("#") == 0) {
					now.right = null;
				} else {
					TreeNode r = new TreeNode();
					r.val = Integer.parseInt(ls[j + 1]);
					now.right = r;
				}
				j++;
			}
			que[end++] = now.left;
			que[end++] = now.right;
		}
		return root;
	}
	public static void show(TreeNode root){
		if(root == null) return;
		show(root.left);
		System.out.println(root.val);
		show(root.right);
	}
	public static void main(String[] args) {
		TreeNode root = generateTreeNode("1,#,2,3");
		show(root);
	}
	
}
