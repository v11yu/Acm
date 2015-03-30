package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * @author v11
 */
public class CombinationSum2 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> tmp = new ArrayList<Integer>();
	Map<String, Integer> m = new HashMap<String, Integer>();
	void dfs(int deep,int[] candidates,int left){
		if(left == 0){
			List<Integer> ans = new ArrayList<Integer>();
			String str = new String();
			ans.addAll(tmp);
			for(Integer t : ans){
				str+=(t+"");
			}
			if(m.containsKey(str)) return;
			m.put(str, 1);
			res.add(ans);
			return ;
		}
		if(deep==candidates.length||candidates[deep]>left ) return ;

		
		tmp.add(candidates[deep]);
		dfs(deep+1,candidates,left-candidates[deep]);
		tmp.remove(tmp.size()-1);
		
		dfs(deep+1,candidates,left);
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		dfs(0,candidates,target);
		return res;
	}
}
