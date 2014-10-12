package leetcode.problem;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int res = Integer.MIN_VALUE,tmp = 0;
		for(int num:A){
			tmp += num;
			if(tmp>res) res = tmp;
			if(tmp<0) tmp = 0;
		}
		return res;
	}
}
