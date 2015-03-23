package leetcode.problem;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author v11
 */
public class LongestPalindromicSubstring {
	int l = 0, r = 0, len = 0;
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] c = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			get(c, i, i);
			get(c, i, i + 1);
		}
		return s.substring(l, r + 1);
	}
	void get(char[] c, int i, int j) {
		for (int tmp = 0; i >= 0 && j < c.length && c[i] == c[j]; i--, j++) {
			tmp = j - i + 1;
			if (tmp > len) {
				len = tmp;
				l = i;
				r = j;
			}
		}
	}
}
