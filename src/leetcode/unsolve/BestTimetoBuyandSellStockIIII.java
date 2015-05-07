package leetcode.unsolve;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.unsolve.BestTimetoBuyandSellStockIII.Pair;

public class BestTimetoBuyandSellStockIIII {
	public int maxProfit(int k,int[] p) {
		int res = 0;
		Pair[] pairs = new Pair[p.length];
		List<Integer> ls = new ArrayList<Integer>();
		int st = 0;
		for(int i=0;i<p.length;i++){
			for(;i<p.length-1&&p[i]>p[i+1];i++);
			int valley = p[i];
			for(;i<p.length-1&&p[i]<p[i+1];i++);
			int peak = p[i];
			if(valley == peak) continue;
			Pair p2 = new Pair(valley,peak);
			
			if(st>0){
				Pair p1 = pairs[st - 1];
				
				if(p1.x <= p2.x && p1.y <= p2.y ){
					while(st>0 && p1.x <= p2.x && p1.y <= p2.y){
						p1 = pairs[st - 1];
						ls.add(p1.y - p2.x);
						p2.x = p1.x;
						st --;
					}
				}else{
					if(p1.x < p2.x){
						
					}else{
						// p1.x > p2.x
						while(st>0 && pairs[st-1].x >= p2.x){
							p1 = pairs[st - 1];
							ls.add(p1.y - p1.x);
							st --;
						}
					}
				}
			}
			pairs[st++] = p2;
		}
		while(st>0)ls.add(pairs[st-1].y - pairs[--st].x);
		Collections.sort(ls);

		for(int i=ls.size()-1;k>0&&i>=0;i--,k--) res += ls.get(i);
		return res;
	}
	class Pair{int x, y;public Pair(int x,int y){this.x = x;this.y=y;}}
	public static void main(String[] args) {
		int k =7;
		int p[] = {1,4,7,5,6,2,5,1,9,7,9,7,0,6,8};
		System.out.println(new BestTimetoBuyandSellStockIIII().maxProfit(k, p));
	}
}
