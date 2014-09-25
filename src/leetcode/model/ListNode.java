package leetcode.model;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x,ListNode next) {
		this.val = x;
		this.next = next;
	}
	/** {2 3 4 5 6} */
	public static ListNode generateListNode(String str){
		String ls[] = str.split(" ");
		ListNode pre = null;
		for(int i = ls.length-1;i>=0;i--){
			ListNode n = new ListNode(Integer.parseInt(ls[i]), pre);
			pre = n;
		}
		return pre;
	}
	public static void main(String[] args) {
		ListNode node = ListNode.generateListNode("1 2 3 4 5");
		for(ListNode iter = node;iter!=null;iter=iter.next)
			System.out.println(iter.val);
	}
}
