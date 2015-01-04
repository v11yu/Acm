package leetcode.problem;

import leetcode.model.ListNode;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode iter = head;
		ListNode res = null,ans=null;
		while(iter != null){
			boolean f = true;
			ListNode pre = iter; // not null
			iter = iter.next;
			while(iter != null && pre.val == iter.val){
				iter = iter.next;
				f = false;
			}
			if(f){
				if(res == null){
					res = pre;
					ans = res;
				}
				else{
					res.next = pre;
					res = res.next;
				}
			}
		}
		if(null != res) res.next = null;
		return ans;
	}
	public static void main(String[] args) {
		new RemoveDuplicatesfromSortedListII().deleteDuplicates(ListNode.generateListNode("1 2 2"));
	}
}
