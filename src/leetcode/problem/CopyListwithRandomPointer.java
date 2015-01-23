package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

import leetcode.model.RandomListNode;
/**
 * https://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * @author v11
 */
public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		Map<Integer, RandomListNode> mp = new HashMap<Integer, RandomListNode>();
		RandomListNode ch = null;
		RandomListNode tmp = head;
		RandomListNode it = null;
		int i=0;
		while(tmp!=null){
			if(ch == null){
				ch = new RandomListNode(tmp.label);
				it = ch;
			}else{
				RandomListNode ct = new RandomListNode(tmp.label);
				it.next = ct;
				it = ct;
			}
			//tmp.label = i++;
			mp.put(tmp.label,it);
			tmp = tmp.next;
		}
		for(tmp=head,it =ch;tmp!=null;tmp=tmp.next,it=it.next){
			if(tmp.random != null){
				int t = tmp.random.label;
				it.random = mp.get(t);
			}
		}
        return ch;
    }
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(-1);
		RandomListNode res = new CopyListwithRandomPointer().copyRandomList(head);
		System.out.println(res.label);
	}
}
