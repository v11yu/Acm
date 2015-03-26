package leetcode.problem;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import leetcode.model.ListNode;
/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * @author v11
 */
public class MergekSortedLists {
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists==null||lists.size() == 0)
			return null;
		ListNode head = new ListNode(0);
		ListNode p = head;
		PriorityQueue<ListNode> q = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode a, ListNode b) {
				// TODO Auto-generated method stub
				if (a.val > b.val)
					return 1;
				else if(a.val == b.val)
					return 0;
				else 
					return -1;
			}
		});
		for (ListNode list : lists) {
			if (list != null)
				q.add(list);
		}
		while(q.size()>0){
			ListNode cur = q.poll();
			p.next = cur;
			if(cur.next !=null){
				q.add(cur.next);
			}
			p=p.next;
		}
		return head.next;
	}
	public static void main(String[] args) {
		
	}
}
