package leetcode.problem;
/**
 * https://oj.leetcode.com/problems/edit-distance/
 * 
 * @author v11
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++) dp[i][0] = i;
        for(int i=0;i<=word2.length();i++) dp[0][i] = i;
		for(int i=1;i<=word1.length();i++){
        	for(int j=1;j<=word2.length();j++){
        		int ii = i-1,jj = j-1;
        		if(word1.charAt(ii) == word2.charAt(jj)) dp[i][j] = dp[i-1][j-1] ;
        		else dp[i][j] = dp[i-1][j-1] +1;
        		dp[i][j] = Math.min(dp[i-1][j]+1, dp[i][j]);
        		dp[i][j] = Math.min(dp[i][j-1]+1, dp[i][j]);
        	}
        }
		return dp[word1.length()][word2.length()];
    }
}
