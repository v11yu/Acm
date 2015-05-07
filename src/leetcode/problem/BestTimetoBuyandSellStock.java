package leetcode.problem;
/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author v11
 */
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int min=Integer.MAX_VALUE,res = 0;
		for(int price:prices){
			min = Math.min(price,min);
			res = Math.max(res, price-min);
		}
		return res;
	}
}
