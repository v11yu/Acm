package leetcode.problem;
/**
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * @author v11
 */
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(S.length()<T.length()) return 0;
		int dp[][] = new int[S.length()][T.length()];
		for(int i=0;i<S.length();i++){
			for(int j=0;j<T.length();j++){
				if(i>0) dp[i][j] = dp[i-1][j];
				if(S.charAt(i) == T.charAt(j)){
					if(i>0&&j>0) dp[i][j] += dp[i-1][j-1];
					if(j == 0) dp[i][j] +=1;
				}
			}
		}
		return dp[S.length()-1][T.length()-1];
	}
	public static void main(String[] args) {
		System.out.println(new DistinctSubsequences().numDistinct("ccc", "c"));
	}
}
