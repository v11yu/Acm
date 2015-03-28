package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * @author v11
 */
public class LetterNumber {
	List<String> res = new ArrayList<String>();
	char[] cc;
	String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	void dfs(char[] c,int cur){
		if(cur==c.length){
			res.add(new String(cc));
			return;
		}
		String str = mapping[c[cur]-'0'];
		for(int i=0;i<str.length();i++){
			cc[cur] = str.charAt(i);
			dfs(c,cur+1);
		}
	}
	public List<String> letterCombinations(String digits) {
		if(digits ==null || digits.length() ==0) return res;
		cc = new char[digits.length()];
		char[] c = digits.toCharArray();
		dfs(c,0);
		return res;

	}
	public static void main(String[] args) {
		System.out.println(new LetterNumber().mapping[2]);
		System.out.println(new LetterNumber().letterCombinations("23"));
	}
}
