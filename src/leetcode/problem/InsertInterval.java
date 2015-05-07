package leetcode.problem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.model.Interval;
/**
 * https://leetcode.com/problems/insert-interval/
 * 
 * @author v11
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		PriorityQueue<Interval> que = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval o1,Interval o2) {
				return o2.end-o1.end;
			}
		});
		que.add(newInterval);
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
		Collections.sort(intervals,new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		return intervals;
	}
}
