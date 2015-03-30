package leetcode.unsolve;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * @author v11
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if(s==null||p==null) return false;
		int n = s.length(),m=p.length();
		if(n == 0 ||m == 0) return false;
		boolean dp[][] = new boolean[2][n];
		if(p.charAt(0) == '.'|| p.charAt(0) == s.charAt(0)) dp[0][0] = true;
		if(p.charAt(0) == '*'){
			for(int i=0;i<n;i++) dp[0][i] = true;
		}
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				dp[i%2][j] = false;
				if(dp[(i-1)%2][j-1]){
					if(p.charAt(j) == '.'|| p.charAt(j) == s.charAt(i)||p.charAt(j)=='*')
						dp[i%2][j] = true;
				}
				if(p.charAt(j)=='*' && dp[i%2][j-1]) dp[i%2][j] = true;
			}
		}
		return dp[(m-1)%2][n-1];
	}
}
