package leetcode.unsolve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node{
	double value;
	String name;
	public Node(double value,String name){
		this.value = value;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + ", name=" + name + "]";
	}
	
}

public class Test {
	public static void main(String[] args) {
		List<Node> nodes = new ArrayList<>();
		Node a = new Node(1.4, "1.4");
		Node b = new Node(1.4444, "1.4444");
		Node c = new Node(1.4000000000000001, "1.40001");
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		Collections.sort(nodes, new Comparator<Node>() {
			public int compare(Node a, Node b) {
				double diff = a.value - b.value;
				double threshold = 1e-20;
				if (diff < threshold)
					return 1;
				else if (diff > threshold)
					return -1;
				else
					return 0;
			}
		});
		System.out.println(nodes);
		
		Node[] as = new Node[nodes.size()];
		as = nodes.toArray(as);
		for(Node qqa:as){
			System.out.println(qqa);
		}
	}
}
