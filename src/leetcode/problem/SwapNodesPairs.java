package leetcode.problem;

import leetcode.model.ListNode;
/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author v11
 */
public class SwapNodesPairs {
	public ListNode swapPairs(ListNode head) {
		int k = 2,cnt=0;
		ListNode cur = head;
		while(cur !=null && cnt<k){
			cnt++;
			cur = cur.next;
		}
		if(cnt == k){
			cur = swapPairs(cur);
			while(cnt -- > 0){
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
			}
			head = cur;
		}
		return head;
	}
}
