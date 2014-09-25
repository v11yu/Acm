package leetcode.problem;

import leetcode.model.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		sort(head,null);
		return head;
	}
	private void sort(ListNode begin,ListNode end){//o(log(n))
		Integer len = getLen(begin,end);//o(n)
		ListNode mid = getMid(begin,end,len);//o(n)
		if (len > 2) {
			sort(begin, mid);
			sort(mid, end);
		}
		merge(begin,mid,end,len);//o(n)
	}
	private void merge(ListNode begin,ListNode mid,ListNode end,int len){
		int tmp[] = new int[len];
		int c = 0;
		ListNode first = begin;
		ListNode second = mid;
		while(first != mid && second != end){
			if(first.val < second.val){
				tmp[c++] = first.val;
				first = first.next;
			}else{
				tmp[c++] = second.val;
				second = second.next;
			}
		}
		while(first != mid){
			tmp[c++] = first.val;
			first = first.next;
		}
		while(second != end){
			tmp[c++] = second.val;
			second = second.next;
		}
		for(first = begin,c=0;first != end;c++,first = first.next){
			first.val = tmp[c];
		}

	}
	private Integer getLen(ListNode begin,ListNode end){
		Integer res = 0;
		ListNode iter = begin;
		while(iter != end){
			iter = iter.next;
			res ++;
		}
		return res;
	}
	private ListNode getMid(ListNode begin,ListNode end,Integer len){
		ListNode iter = begin;
		int count = len/2;
		while(iter != end && count > 0){
			count --;
			iter = iter.next;
		}
		return iter;
	}
	public static void main(String[] args) {
		ListNode head = ListNode.generateListNode("5 4 3 9 2 1");
		ListNode iter = null;
		SortList sortL = new SortList();
		iter = sortL.sortList(head);
		while(iter != null){
			System.out.println(iter.val);
			iter = iter.next;
		}
	}
}
