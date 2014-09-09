package codeforces.div_2_265;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class C {
	static int n,m;
	static char ss[];
	static boolean no = false;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		ss = new char[n];
		String str = cin.next();
		ss = str.toCharArray();
		int loop = 500,i=0;
		for(i=0;i<loop&&!no;i++){
			add(ss);
			if(check(new String(ss))){
				break;
			}
		}
		if(!no&&i<loop) System.out.println(new String(ss));
		else System.out.println("NO");
		
	}
	public static boolean check(String str){
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) - 'a' >= m) return false;
		}
		int longest = ManachersAlgorithm.findLongestPalindrome(str).length();
		if(longest > 1) return false;
		return true;
	}
	public static char[] add(char str[]){
		char Max = (char) ('a'+m );
		for(int i = n-1;i>=0;i--){
			str[i] = (char) (str[i]+1);
			if(str[i] >= Max){
				str[i] = 'a';
				if(i == 0){
					no = true;
				}
			}
			else{
				break;
			}
		}
		return str;
	}
}
class ManachersAlgorithm  {

	public static String findLongestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";

		char[] s2 = addBoundaries(s.toCharArray());
		int[] p = new int[s2.length];
		int c = 0, r = 0; // Here the first element in s2 has been processed.
		int m = 0, n = 0; // The walking indices to compare if two elements are
							// the same
		for (int i = 1; i < s2.length; i++) {
			if (i > r) {
				p[i] = 0;
				m = i - 1;
				n = i + 1;
			} else {
				int i2 = c * 2 - i;
				if (p[i2] < (r - i)) {
					p[i] = p[i2];
					m = -1; // This signals bypassing the while loop below.
				} else {
					p[i] = r - i;
					n = r + 1;
					m = i * 2 - n;
				}
			}
			while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
				p[i]++;
				m--;
				n++;
			}
			if ((i + p[i]) > r) {
				c = i;
				r = i + p[i];
			}
		}
		int len = 0;
		c = 0;
		for (int i = 1; i < s2.length; i++) {
			if (len < p[i]) {
				len = p[i];
				c = i;
			}
		}
		char[] ss = Arrays.copyOfRange(s2, c - len, c + len + 1);
		return String.valueOf(removeBoundaries(ss));
	}

	private static char[] addBoundaries(char[] cs) {
		if (cs == null || cs.length == 0)
			return "||".toCharArray();

		char[] cs2 = new char[cs.length * 2 + 1];
		for (int i = 0; i < (cs2.length - 1); i = i + 2) {
			cs2[i] = '|';
			cs2[i + 1] = cs[i / 2];
		}
		cs2[cs2.length - 1] = '|';
		return cs2;
	}

	private static char[] removeBoundaries(char[] cs) {
		if (cs == null || cs.length < 3)
			return "".toCharArray();

		char[] cs2 = new char[(cs.length - 1) / 2];
		for (int i = 0; i < cs2.length; i++) {
			cs2[i] = cs[i * 2 + 1];
		}
		return cs2;
	}
}
