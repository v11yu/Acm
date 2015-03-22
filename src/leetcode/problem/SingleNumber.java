package leetcode.problem;

/**
 * https://leetcode.com/problems/single-number/
 * 
 * @author v11
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		for (int i = 1; i < A.length; i++) {
			A[0] ^= A[i];
		}
		return A[0];
	}
}
