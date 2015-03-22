package leetcode.problem;
/**
 * https://leetcode.com/problems/number-of-1-bits/
 * 
 * @author v11
 */
public class NumberOf1Bits {
	public int hammingWeight(int n) {
		int ans = 0;
		for(int i=0;i<32;i++){
			if((n&1) ==1 ) ans ++;
			n>>>=1;
		}
		return ans;
	}

}
