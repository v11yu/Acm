package leetcode.problem;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/permutations/
 * 
 * @author v11
 */
public class Permutations {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> tmp = new ArrayList<Integer>();
	boolean s[];
	void dfs(int n,int[] num){
		if(n == num.length){
			List<Integer> tmp1 = new ArrayList<Integer>();
			tmp1.addAll(tmp);
			res.add(tmp1);
			return ;
		}
		for(int i=0;i<num.length;i++){
			if(!s[i]){
				s[i] = true;
				tmp.add(num[i]);
				dfs(n+1,num);
				s[i] = false;
				tmp.remove(tmp.size()-1);
			}
		}
	}
	public List<List<Integer>> permute(int[] num) {
		s = new boolean[num.length];
		dfs(0,num);
		return res;
	}
}
