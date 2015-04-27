package leetcode.problem;
/**
 * https://leetcode.com/problems/jump-game-ii/
 * 
 * @author v11
 */
public class JumpGameII {
	public int jump(int[] A) {
		if(A==null || A.length <=1) return 0;
		int curMaxReach = A[0];
		int step = 1;
		int nextMaxReach = -1;
		for(int i=1;i<A.length;i++){
			if(i>curMaxReach) {
				curMaxReach = nextMaxReach;
				step++;
			}
			if(i+A[i] > nextMaxReach) nextMaxReach = i+A[i];
			if(curMaxReach>= A.length-1) return step;
			
		}
		return step;
	}
	public static void main(String[] args) {
		
	}
}
