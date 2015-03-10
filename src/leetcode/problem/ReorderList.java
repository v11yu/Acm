package leetcode.problem;

import leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/reorder-list/
 * 
 * @author v11
 */
public class ReorderList {
	public ListNode rList(ListNode head){
		ListNode now = head;
		ListNode pre = null;
		while(now!=null){
			ListNode tmp = now.next;
			now.next = pre;
			pre = now;
			now = tmp;
		}
		return pre;
	}
	public void reorderList(ListNode head) {
		if(head==null || head.next==null) return ;
		ListNode slow = head;
		ListNode fast = head.next;
		ListNode p1 = slow;
		ListNode p2 = fast;
		while(p2!=null&&p2.next!=null){
			p1 = p1.next;
			p2 = p2.next;
			if(p2!=null) p2 = p2.next;
		}
		fast = p1.next;
		p1.next = null;
		fast = rList(fast);
		System.out.println(slow);
		System.out.println(fast);
		p1 = slow;
		p2 = fast;
		while(p1!=null && p2!=null){
			ListNode tmp = p1.next;
			p1.next = p2;
			p1 = tmp;
			tmp = p2.next;
			p2.next = p1;
			p2 = tmp;
		}
		System.out.println(head);
	}
	public static void main(String[] args) {
		new ReorderList().reorderList(ListNode.generateListNode("1 2 3 4 5"));
	}
}
