package leetcode.problem;

import java.util.ArrayList;
import java.util.List;
/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * @author v11
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		int len = s.length();
		List<List<String>>[] res = new List[len+1];
		for(int i=0;i<=len;i++) res[i] = new ArrayList<List<String>>();
		res[0].add(new ArrayList<String>());
		boolean dp[][] = new boolean[len][len]; // [i][j] -> str.sub(j ,i)
		for(int i=0;i<len;i++){
			char c = s.charAt(i);
			for(int j=0;j<=i;j++){
				char cc = s.charAt(j);
				if(j == i) dp[i][j] = true;
				else if(cc==c){
					if(j==i-1)dp[i][j] = true;
					else dp[i][j] = dp[i-1][j+1];
				}
				if(dp[i][j]){
					int left = j;
					for(List<String> it:res[j]){
						List<String> tmp = new ArrayList<String>();
						tmp.addAll(it);
						tmp.add(s.substring(j, i+1));
						res[i+1].add(tmp);
					}
				}
			}
		}
		return res[len];
	}
}
