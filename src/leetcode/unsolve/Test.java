package leetcode.unsolve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.model.ListNode;
import leetcode.model.Point;

public class Test {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode lead = new ListNode(-1);
		lead.next = head;
		ListNode it = lead,pre = lead;
		while(it!=null){
			boolean f = false;
			while(it.next!=null && it.val == it.next.val){
				it.next=it.next.next;
				f = true;
			}
			if(f)pre.next =it.next;
			pre = it;
			it = it.next;
			
		}
		return lead.next;
	}
	public static void main(String[] args) {
		ListNode ls = new Test().deleteDuplicates(ListNode.generateListNode("1 1"));
		System.out.println(ls);
	}
}
