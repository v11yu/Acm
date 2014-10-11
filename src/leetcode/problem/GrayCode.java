package leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		Set<Integer> nums = new HashSet<Integer>();
		List<Integer> res = new ArrayList<Integer>();
		n = (1<<n)-1 ;
		//System.out.println(n);
		int now = 0;
		nums.add(0);
		res.add(0);
		while(nums.size()<=n){
			int d = 1;
			while(true){
				int tmp = now;
				if(!nums.contains(now^d)){
					now = now^d; 
					res.add(now);
					nums.add(now);
					break;
				}
				d*=2;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(2));
	}
}
