package leetcode.unsolve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.model.Point;


public class Test {
	public static void main(String[] args) {
		List<Point> ls = new ArrayList<Point>();
		ls.add(new Point(1,2));
		ls.add(new Point(1,3));
		ls.add(new Point(1,5));
		ls.add(new Point(1,6));
		Point t = ls.get(0);
		ls.set(0, ls.get(1));
		ls.set(1, t);
		System.out.println(t);
		System.out.println(ls);
	}
}
