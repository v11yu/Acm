package leetcode.problem;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * @author v11
 */
public class StringtoInteger {
	public int atoi(String str) {
		if(str == null || str.length()==0) return 0;
		str = str.trim();
		boolean f=false;
		int bg = 0;
		if(str.charAt(0) == '-'){
			f = true;
			bg = 1;
		}
		if(str.charAt(0) == '+'){
			bg = 1;
		}
		if(str.charAt(0)=='+' || str.charAt(0) == '-'){
			if(str.length()>1&&!(str.charAt(1)>='0'&&str.charAt(1)<='9')) return 0;
		}
		double res = 0;
		for(;bg<str.length();bg++){
			if(!(str.charAt(bg)>='0'&&str.charAt(bg)<='9')) break;
			res = res*10+str.charAt(bg)-'0';
		}
		if(f) res=-res;
		if(!f&&res<0) return Integer.MAX_VALUE;
		if(f&&res>0) return Integer.MIN_VALUE;
		return (int)res;
	}
	public static void main(String[] args) {
		int t = new StringtoInteger().atoi("1a");
		System.out.println(t);
	}
}
