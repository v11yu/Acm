package leetcode.unsolve;

public class SingleNumberII {
	public int singleNumber(int[] A) {
		int d[] = new int [32];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<32;j++){
				if(((1<<j) & A[i]) !=0) d[j]++;
				//d[j] += ((A[i]>>j)&1);
			}
		}
		for(int i=0;i<32;i++){
			System.out.println(d[i]);
		}
		int res = 0;
		for(int i=0;i<32;i++){
			if(d[i]%3 == 1) res += (1<<i);
		}
		return res;
	}
	public static void main(String[] args) {
		int A[]={-2,-2,1,1,-3,1,-3,-3,-4,-2};
		int t = new SingleNumberII().singleNumber(A);
		System.out.println(t);
	}
}
