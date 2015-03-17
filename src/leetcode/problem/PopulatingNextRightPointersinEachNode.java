package leetcode.problem;

import leetcode.model.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author v11
 */
public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = root;
		while (head != null) {
			TreeLinkNode cur = head;
			while (cur != null) {
				if (cur.left != null) {
					cur.left.next = cur.right;
					if (cur.next != null) {
						cur.right.next = cur.next.left;
					}
				}
				cur = cur.next;
			}
			head = head.left;
		}
	}
	public static void main(String[] args) {

		new PopulatingNextRightPointersinEachNode().connect(TreeLinkNode.generateTreeNode("1,2,3"));
	}
}
