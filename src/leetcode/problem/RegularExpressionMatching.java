package leetcode.problem;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
    	int ls = s.length()+1;
    	int lp = p.length()+1;
    	boolean dp[][] = new boolean[ls][lp];
    	dp[0][0] = true;
    	for(int i=2;i<lp;i++){
    		int ii = i-1;
    		if(p.charAt(ii)=='*'&&dp[0][i-2]) 
    			dp[0][i] = true;
    	}
    	for(int i=1;i<ls;i++){
    		for(int j=1;j<lp;j++){
    			int ii = i-1;
				int jj = j-1;
    			if(dp[i-1][j-1]){
    				if(s.charAt(ii) == p.charAt(jj)||p.charAt(jj)=='.')dp[i][j] = true;
    				if(p.charAt(jj)=='*'){
    					if( p.charAt(jj-1)== s.charAt(ii) || p.charAt(jj-1) == '.')
    						dp[i][j] = true;
    				}
    			}
    			if(dp[i-1][j]){
    				if(p.charAt(jj)=='*' ){
    					if( p.charAt(jj-1)== s.charAt(ii) || p.charAt(jj-1) == '.')
    						dp[i][j] = true;
    				}
    			}
    			if(j-2>=0&&dp[i][j-2]){
    				if(p.charAt(jj) == '*') dp[i][j] = true;
    			}
    		}
    	}
		return dp[ls-1][lp-1];
    }
    public static void main(String[] args) {
    	String s = "aab";
    	String p = "c*a*b";
		System.out.println(new RegularExpressionMatching().isMatch(s, p));
	}
}
