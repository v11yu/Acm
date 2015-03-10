package leetcode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/
 * 
 * @author v11
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict){
		int len = s.length();
		boolean dp[] = new boolean[len];
		for(int i=0;i<len;i++){
			if(dict.contains(s.substring(0, i+1))) dp[i] = true;
			else{
				for(int j=0;j<i;j++){
					if(dp[j] && dict.contains(s.substring(j+1, i+1))){
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[len-1];
	}
	public static void main(String[] args) {
		WordBreak t = new WordBreak();
		String s = "leetcode1";
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(t.wordBreak(s, dict));
	}
}
