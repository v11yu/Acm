package leetcode.problem;

import leetcode.model.ListNode;
/**
 * https://oj.leetcode.com/problems/linked-list-cycle-ii/
 * 
 * @author v11
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null){
			fast = fast.next;
			slow = slow.next;
			if(fast!=null) fast = fast.next;
			else return null;
			if(fast == slow){
				for(fast = head;fast!=slow;fast=fast.next,slow=slow.next);
				return fast;
			}
		}
		return null;
	}
}
