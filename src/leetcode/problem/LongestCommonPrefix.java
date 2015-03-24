package leetcode.problem;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * @author v11
 */
public class LongestCommonPrefix {
	String get(String a,String b){
		if(a==null||b==null) return null;
		int p=0;
		for(int i=0;i<a.length()&&i<b.length();i++){
			if(a.charAt(i)!=b.charAt(i)) break;
			p++;
		}
		if(p == 0) return null;
		return a.substring(0, p);
	}
	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0 || strs == null) return "";
		if(strs.length == 1) return strs[0];
		for(int i=1;i<strs.length;i++){
			strs[0] = get(strs[0],strs[i]);
		}
		return strs[0];
	}
}
