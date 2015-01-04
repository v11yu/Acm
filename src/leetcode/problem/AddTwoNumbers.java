package leetcode.problem;

import leetcode.model.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class AddTwoNumbers {
	ListNode getAns(ListNode l,ListNode l2){
		int tmp = 0;
		ListNode l1 = l;
		while(l1 != null){
			l1.val += (l2.val+tmp);
			if(l1.val >= 10){
				l1.val-=10;
				tmp = 1;
			}else {
				tmp = 0;
			}
			l1 = l1.next;
			l2 = l2.next;
			if(l2.next !=null){
				
			}else{
				l2.val = 0;
			}
		}
		if(tmp == 1){
			l1 = l;
			while(l1.next !=null) l1 = l1.next;
			l1.next = new ListNode(1);
		}
		return l;
	}
	int getLen(ListNode l){
		int res = 0;
		while(l.next !=null) {
			res++;
			l = l.next;
		}
		return res;
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(getLen(l1)>getLen(l2)) return getAns(l1,l2);
		else return getAns(l2,l1);
	}

}
