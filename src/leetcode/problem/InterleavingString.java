package leetcode.problem;
/**
 * https://leetcode.com/problems/interleaving-string/
 * 
 * @author v11
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length() != s3.length()) return false;
		boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
		dp[0][0] = true;
		for(int i=0;i<=s1.length();i++){
			for(int j=0;j<=s2.length();j++){
				if(i>0 && s1.charAt(i-1) == s3.charAt(i+j-1)) dp[i][j] = dp[i-1][j];
				if(j>0 && s3.charAt(i+j-1) == s2.charAt(j-1)&&!dp[i][j]) dp[i][j] = dp[i][j-1];
			}
		}
		return dp[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		String s1 = "ab";
		String s2 = "bc";
		String s3 = "babc";
		boolean f = new InterleavingString().isInterleave(s1, s2, s3);
		System.out.println(f);
	}
}
