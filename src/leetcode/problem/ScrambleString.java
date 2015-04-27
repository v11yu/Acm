package leetcode.problem;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/scramble-string/
 * 
 * @author v11
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(!Arrays.equals(c1, c2)) return false;
		if(s1.length() == 1) return true;
		for(int i=1;i<s1.length();i++){
			if(isScramble(s1.substring(i), s2.substring(i)) && isScramble(s1.substring(0, i), s2.substring(0, i))) return true;
			if(isScramble(s1.substring(i), s2.substring(0,s1.length()-i))&&isScramble(s1.substring(0, i), s2.substring(s1.length()-i))) return true;
		}
		return false;
	}
}
