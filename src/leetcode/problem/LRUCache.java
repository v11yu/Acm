package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
	LinkNode cpLink;
	int cap;
	public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
		return key;
        
    }
    
    public void set(int key, int value) {
    	if(!mp.containsKey(key)){
    		if(mp.size() == cap){
    			removeCap(key);
    		}
    		addCap(key);
    	}else{
    		useCap(key);
    	}
    	mp.put(key,value);
    }
    private void useCap(int key){
    	// find -> add head
    }
    private void addCap(int key){
    	// add head O(1)
    }
    private void removeCap(int key){
    	//find ->remove
    }
}
class LinkNode{
	int val;
	LinkNode next;
}