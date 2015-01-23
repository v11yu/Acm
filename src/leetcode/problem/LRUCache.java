package leetcode.problem;

import java.util.HashMap;
import java.util.Map;
/**
 * https://oj.leetcode.com/problems/lru-cache/
 * 
 * @author v11
 */
public class LRUCache {
	Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	Map<Integer, LinkNode> mpl = new HashMap<Integer, LinkNode>();
	LinkNode head,last;
	int cap;
	public LRUCache(int capacity) {
        this.cap = capacity;
        head = null;
    }
    public int get(int key) {
    	if(mp.containsKey(key)){
    		useCap(key);
    		return mp.get(key);
    	}
		return -1;
    }
    public void set(int key, int value) {
    	if(!mp.containsKey(key)){
    		if(mp.size() == cap){
    			int tmp = last.val;
    			removeCap(last.val);
    			mp.remove(tmp);
    			mpl.remove(tmp);
    		}
    		addCap(key,value);
    	}else{
    		mp.put(key,value);
    		useCap(key);
    	}	
    }
    private void useCap(int key){
    	// find -> add head
    	removeCap(key);
    	addHead(key);
    }
    private void addCap(int key,int value){
    	mp.put(key,value);
    	addHead(key);
    	// add head O(1)
    }
    private void addHead(int key){
    	LinkNode tmp = new LinkNode(key);
    	if(head == null){
    		tmp.next = head;
    		head = tmp;
		} else {
			tmp.next = head;
			head.pre = tmp;
			head = tmp;
		}
    	mpl.put(tmp.val, tmp);
    	if(head.next == null) last = head;
    }

	private void removeCap(int key) {
		// find ->remove
		LinkNode tmp = mpl.get(key);
		if(tmp.next == null) {
			if(tmp.pre !=null) last = tmp.pre;
			else last = null;
		}
		if(tmp.pre == null) {
			if(tmp.next !=null) head = tmp.next;
			else head = null;
		}
		if (tmp.pre != null) {
			tmp.pre.next = tmp.next;
		}
		if (tmp.next != null) {
			tmp.next.pre = tmp.pre;
		}
		if(tmp.next == null && tmp.pre ==null){
			head = null;
		}
	}
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(2);
		lru.set(2, 1);
		lru.set(3,2);
		System.out.println(lru.get(3));
		System.out.println(lru.get(2));
		lru.set(4,3);
		System.out.println(lru.get(2));
		System.out.println(lru.get(3));
		System.out.println(lru.get(4));
		

	}
}
class LinkNode{
	int val;
	LinkNode next;
	LinkNode pre;
	public LinkNode(int x){
		this.val = x;
		this.next = null;
		this.pre = null;
	}
}