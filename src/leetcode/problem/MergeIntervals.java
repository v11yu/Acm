package leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.model.Interval;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		PriorityQueue<Interval> que = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval o1,Interval o2) {
				return o2.end-o1.end;
			}
		});
		for(Interval it :intervals) que.add(it);
		intervals.clear();
		while(!que.isEmpty()){
			Interval first = que.poll();
			Interval second = que.poll();
			if(second == null || first.start>second.end) intervals.add(first);
			else{
				second.end = first.end;
				second.start = Math.min(second.start, first.start);
			}
			if(second!=null) que.add(second);
		}
		return intervals;
	}
	public static void main(String[] args) {
		List<Interval> res = new ArrayList<Interval>();
		res.add(new Interval(2,6));
		res.add(new Interval(1,3));
		res.add(new Interval(8,10));
		res.add(new Interval(15,18));
		res = new MergeIntervals().merge(res);
		System.out.println(res);
	}
}
