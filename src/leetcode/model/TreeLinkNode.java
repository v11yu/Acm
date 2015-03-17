package leetcode.model;

public class TreeLinkNode {
	public static int MAX = 10000000;
	public int val;
	public TreeLinkNode left, right, next;
	public TreeLinkNode(int x) {val = x;}
	public TreeLinkNode() {}
	/**
	 * generated TreeNode by String
	 * @param s : "1,#,2,3"
	 */
	public static TreeLinkNode generateTreeNode(String s){
		TreeLinkNode root = new TreeLinkNode();
		String ls[] = s.split(",");
		if(ls[0].compareTo("#") == 0){
			root = null;
		}
		else {
			root.val = Integer.parseInt(ls[0]);
		}
		TreeLinkNode que[] = new TreeLinkNode[MAX];
		int top=0,end=0;
		que[end++] = root;
		int j = 0;
		while(top<end){
			TreeLinkNode now = que[top++];
			if(now == null)
				continue;
			if(j+1 < ls.length){
				if (ls[j + 1].compareTo("#") == 0) {
					now.left = null;
				} else {
					TreeLinkNode l = new TreeLinkNode();
					l.val = Integer.parseInt(ls[j + 1]);
					now.left = l;
				}
				j++;
			}
			if(j+1 < ls.length){
				if (ls[j + 1].compareTo("#") == 0) {
					now.right = null;
				} else {
					TreeLinkNode r = new TreeLinkNode();
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
}
