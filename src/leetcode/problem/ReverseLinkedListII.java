package leetcode.problem;

import leetcode.model.ListNode;

public class ReverseLinkedListII {
	void swap(ListNode ln,ListNode lm){
		ln.val ^= lm.val;
		lm.val ^= ln.val;
		ln.val ^= lm.val;
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(n<m){ // make m<n
			n^=m;
			m^=n;
			n^=m;
		}
		ListNode tmp[] = new ListNode[n-m+1];
		ListNode iter = head;
		int cnt = 0;
		for(int i=1;i<=n;i++){
			if(i >= m) tmp[cnt++] = iter;
			iter = iter.next;
		}
		for(int i=0;i<cnt/2;i++){
			swap(tmp[i],tmp[cnt-1-i]);
		}
		return head;
	}
	public static void main(String[] args) {
		new ReverseLinkedListII().reverseBetween(ListNode.generateListNode("3 5"), 1, 2);
	}
}
