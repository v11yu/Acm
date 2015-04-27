package leetcode.problem;
/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * 
 * @author v11
 */
public class PalindromePartitioning2 {
	public int minCut(String s) {
		int n = s.length();
		int dp[] = new int[n+1];
		for(int i=1;i<=n;i++) dp[i] = -1;
		boolean m[][]= new boolean[n][n]; // [i][j] sub(j,i)

		for(int i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				if(i == j) m[i][j] = true;
				else if(s.charAt(i) == s.charAt(j)){
					if(j == i-1) m[i][j] = true;
					else m[i][j] = m[i-1][j+1];
				}
				if(m[i][j]){
					if(j == 0) dp[i+1] = 0;
					else{
						if(dp[i+1] == -1) dp[i+1] = dp[j] + 1;
						else dp[i+1] = Math.min(dp[j] + 1,dp[i+1]);
					}
				}
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning2().minCut("abcdf"));
	}
}
