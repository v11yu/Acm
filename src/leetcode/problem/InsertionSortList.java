package leetcode.problem;

import leetcode.model.ListNode;

/**
 * Sort a linked list using insertion sort.
 * @author v11
 * @date 2014年11月6日
 * @version 1.0
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode res = null;
		for(ListNode i = head;i!=null;i=i.next){
			if(res == null){
				res = new ListNode(i.val);
			}else{
				for(ListNode j = res;j!=null;j=j.next){
					if(i.val < j.val ){
						ListNode tmp = new ListNode(j.val);
						tmp.next = j.next;
						j.val = i.val;
						j.next = tmp;
						break;
					}else if (j.next == null){
						ListNode tmp = new ListNode(i.val);
						j.next = tmp;
						break;
					}
				}
			}
		}
		return res;
    }
	public static void main(String[] args) {
		new InsertionSortList().insertionSortList(ListNode.generateListNode("3 2 4"));
	}
}
