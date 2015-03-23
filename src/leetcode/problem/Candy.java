package leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://oj.leetcode.com/problems/candy/
 * 
 * @author v11
 */
public class Candy {

	public int candy(int[] ratings) {
		int[] sum = new int[ratings.length];
		for(int i=0;i<sum.length;i++) sum[i] = 1;
		for(int i=1;i<sum.length;i++){
			if(ratings[i] > ratings[i-1]) sum[i] = sum[i-1] +1;
		}
		for(int i=sum.length-1;i>0;i--){
			if(ratings[i-1] > ratings[i]) sum[i-1] = Math.max(sum[i]+1, sum[i-1]);
		}
		int res = 0;
		for(int i=0;i<sum.length;i++) res+=sum[i];
		return res;
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 3, 2, 5 };
		new Candy().candy(a);
	}
}
