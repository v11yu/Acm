package leetcode.problem;

public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		int res = Integer.MIN_VALUE;
		int tmp = 1;
		for(int i=0;i<A.length;i++){
			tmp *= A[i];
			if(tmp > res) res = tmp;
			if(tmp == 0) tmp =1;
		}
		tmp = 1;
		for(int i=A.length-1;i>=0;i--){
			tmp *= A[i];
			if(tmp > res) res = tmp;
			if(tmp == 0) tmp =1;
		}
		return res;
	}
}
