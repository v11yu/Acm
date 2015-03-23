package leetcode.problem;

import java.util.HashMap;

import leetcode.model.UndirectedGraphNode;

/**
 * https://leetcode.com/problems/clone-graph/
 * 
 * @author v11
 */
public class CloneGraph {
	HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		if(map.containsKey(node.label)) return map.get(node.label);
		UndirectedGraphNode r = new UndirectedGraphNode(node.label);
		map.put(node.label, r);
		for(UndirectedGraphNode it:node.neighbors){
			r.neighbors.add(cloneGraph(it));
		}
		return r;
	}

}
