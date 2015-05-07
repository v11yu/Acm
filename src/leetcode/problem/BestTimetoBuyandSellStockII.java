package leetcode.problem;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author v11
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] p) {
		int res = 0;
		for(int i=0;i<p.length;i++){
			for(;i<p.length-1&&p[i]>p[i+1];i++);
			int valley = p[i];
			for(;i<p.length-1&&p[i]<p[i+1];i++);
			int peak = p[i];
			res += (peak - valley);
		}
		return res;
	}
}
