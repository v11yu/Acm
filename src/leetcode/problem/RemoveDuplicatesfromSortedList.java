package leetcode.problem;

import leetcode.model.ListNode;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode iter = head;
		while(iter != null){
			ListNode pre = iter;
			iter = iter.next;
			while(iter != null && pre.val == iter.val){
				iter = iter.next;
			}
			pre.next = iter;
		}
		return head;
	}
}
