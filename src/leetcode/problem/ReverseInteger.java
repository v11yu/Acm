package leetcode.problem;
/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 * @author v11
 */
public class ReverseInteger {
	public int reverse(int x) {
		boolean f = false;
		if(x<0){
			f = true;
			x=-x;
		}
		int[] d = new int[12];
		int cnt = 0;
		while(x>0){
			d[cnt++] = x%10;
			x/=10;
		}
		double res = 0;
		for(int i=0;i<cnt;i++){
			res = res*10 + d[i];
		}
		if(f) res = -res;
		if(res >Integer.MAX_VALUE*1.0 || res < Integer.MIN_VALUE*1.0) return 0;
		return (int)res;
	}
}
