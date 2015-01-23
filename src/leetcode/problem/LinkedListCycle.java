package leetcode.problem;

import leetcode.model.ListNode;

/**
 * https://oj.leetcode.com/problems/linked-list-cycle/
 * 
 * @author v11
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
			fast = fast.next;
			slow = slow.next;
			if(fast!=null) fast = fast.next;
			else return false;
			if(fast == slow){
				return true;
			}
		}
		return false;
	}
}
