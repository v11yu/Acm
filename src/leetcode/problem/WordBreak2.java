package leetcode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://oj.leetcode.com/problems/word-break-ii/
 * 
 * @author v11
 */
public class WordBreak2 {
	boolean dp[];
	List<String> res = new ArrayList<>();
	void judge(String str,int pos,Set<String> dict,String ans){
		if(pos == str.length()){
			System.out.println(ans);
			res.add(ans);
			return ;
		}
		String s = "";
		for(int i=pos;i<str.length();i++){
			s += str.charAt(i);
			if(dict.contains(s)){
				if(dp[i]){
					if(ans == null)
						judge(str,i+1,dict,s);
					else 
						judge(str,i+1,dict,ans +" "+ s);
				}
			}
		}
		
	}
	public List<String> wordBreak(String s, Set<String> dict) {
		int len = s.length();
		dp = new boolean[len];
		for(int i=0;i<len;i++){
			if(dict.contains(s.substring(0, i+1))) dp[i] = true;
			else{
				for(int j=0;j<i;j++){
					if(dp[j] && dict.contains(s.substring(j+1, i+1))){
						dp[i] = true;
						break;
					}
				}
			}
		}
		if(!dp[len-1]) return res;
		judge(s,0,dict,null);
		return res;
	}

	public static void main(String[] args) {
		WordBreak2 t = new WordBreak2();
//		t.init(10000);
//		t.insert("haha");
//		t.insert("hahe");
//		System.out.println(t.cnt);
//		System.out.println(t.exist("hahe"));
//		System.out.println(t.exist("hahah"));
		String s = "catsanddog";
		Set<String> dict = new HashSet<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");
		System.out.println(t.wordBreak(s, dict));
	}
}
