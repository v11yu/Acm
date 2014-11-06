package leetcode.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.ShowUtil;
import leetcode.model.Point;

public class MaxPoints {
	public int maxPoints(Point[] points) {
    	int res = Math.min(2, points.length);
    	boolean f = false;
    	for(int i=0;i<points.length;i++){
    		for(int j=0;j<points.length;j++){
    			if(i == j) continue;
    			if(points[i].x == points[j].x && 
    					points[i].y == points[j].y) 
    				continue;
    			f = true;
    			int num = 2;
    			for(int k=0;k<points.length;k++){
    				if(i==k || j==k) continue;
    				if(check(points[i],points[j],points[k]))
    					num++;
    			}
    			res = Math.max(res, num);
    		}
    	}
    	if(!f) res = points.length;
		return res;
    }
    private boolean check(Point a,Point b,Point c){
    	return (a.x-b.x)*(c.y-b.y) == (c.x-b.x)*(a.y-b.y);
    }
}