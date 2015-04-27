package leetcode.unsolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations-ii/
 * 
 * @author v11
 */
public class Permutations2 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> tmp = new ArrayList<Integer>();
	boolean s[];
	void dfs(int n,int[] num){
		if(n == num.length-1){
			List<Integer> tmp1 = new ArrayList<Integer>();
			for(int t:num){
				tmp1.add(t);
			}
			res.add(tmp1);
			return ;
		}
		for(int i=n;i<num.length;i++){
			if(i!=n&&num[i] == num[n]) continue;
			int t = num[i];
			num[i] = num[n];
			num[n] = t;
			dfs(n+1,num);
		}
	}
	public List<List<Integer>> permuteUnique(int[] num) {
		Arrays.sort(num);
		s = new boolean[num.length];
		dfs(0,num);
		return res;
	}
	public static void main(String[] args) {
		int num[] = {3,3,0,0,2,3,2};
		List<List<Integer>> res = new Permutations2().permuteUnique(num);
		System.out.println(res.size());
	}
}
