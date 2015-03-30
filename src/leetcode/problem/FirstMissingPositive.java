package leetcode.problem;

/**
 * https://leetcode.com/problems/first-missing-positive/
 *  1 space
 * @author v11
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		for(int i=0;i<A.length;i++){
			while(A[i]>0 && A[i]<A.length &&A[i]!= A[A[i]-1]){
				int t = A[i]-1;
//				int tmp = A[i];
//				A[i] = A[t];
//				A[t] = tmp;
				A[i] ^= A[t];
				A[t] ^= A[i];
				A[i] ^= A[t];
			}
		}
		for(int i=0;i<A.length;i++){
			if(A[i]!=i+1) return i+1;
		}
		return A.length+1;
	}
	public static void main(String[] args) {
		int a[] = {-1,4,2,1,9,10};
		int t = new FirstMissingPositive().firstMissingPositive(a);
		System.out.println("ans:"+t);
	}

}
