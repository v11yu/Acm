package leetcode.unsolve;

public class RegularExpressionMatching {
	boolean check1(int i,int j,String s,String p){
		i--;j--;
		if(s.charAt(i) == p.charAt(j)||s.charAt(i)=='.'||p.charAt(j)=='.'){
			return true;
		}
		return false;	
	}
	boolean check2(int i,int j,String s,String p){
		if(i-1>=0)
		if(s.charAt(i)=='*'&&s.charAt(i-1)==p.charAt(j)){
			
		}
		return false;
	}
	boolean check3(int i,String s){
		i--;
		if(s.charAt(i)=='*') return true;
		return false;
	}
    public boolean isMatch(String s, String p) {
    	int ls = s.length()+1;
    	int lp = p.length()+1;
    	boolean dp[][] = new boolean[ls][lp];
    
    	System.out.println(dp[0][0]);
    	/*
    	 * init
    	 */
    	dp[0][0] = true;
    	for(int i=2;i<ls;i++){
    		if(check3(i,s)&&dp[i-2][0]) dp[i][0] = true;
    	}
    	for(int i=2;i<ls;i++){
    		if(check3(i,p)&&dp[0][i-2]) dp[0][i] = true;
    	}
    	/*
    	 * dp
    	 */
    	for(int i=1;i<ls;i++){
    		for(int j=1;j<=lp;j++){
    			if(dp[i-1][j-1]){
    				if(check1(i,j,s,p))dp[i][j] = true;
    				if(check2(i,j,s,p)) dp[i][j] = true;
    				if(check2(j,i,p,s)) dp[i][j] = true;
    			}
    		}
    		
    	}
		return false;
    }
    public static void main(String[] args) {
    	String s = "aab";
    	String p = "c*a*b";
		System.out.println(new RegularExpressionMatching().isMatch(s, p));
	}
}
