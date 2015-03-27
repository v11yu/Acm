package leetcode.problem;

import leetcode.model.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * @author v11
 */
public class ReverseNodesink {
	public ListNode reverseKGroup(ListNode head, int k) {
		int cnt = 0;
		ListNode cur = head;
		while(cur!=null && cnt <k){
			cnt++;
			cur = cur.next;
		}
		if(cnt == k){
			cur = reverseKGroup(cur, k);
			while(cnt-->0){
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
			}
			head = cur;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = ListNode.generateListNode("1 2 3 4");
		head = new ReverseNodesink().reverseKGroup(head, 2);
		System.out.println(head.toString());
	}
}
