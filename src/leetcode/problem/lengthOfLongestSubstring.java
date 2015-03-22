package leetcode.problem;

import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author v11
 */
public class lengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int dp[] = new int[s.length()];
		int z=0,pre=0,tmp=0,ans=0;
		int mk[] = new int[50000];
		char sr[] = s.toCharArray();
		for(int i=0;i<sr.length;i++){
			
			if(mk[sr[i]] == 0 ){
				tmp++;
				mk[sr[i]] = 1;
			}
			else{
				while(sr[pre] != sr[i]){
					mk[sr[pre]] = 0;
					tmp--;
					pre++;
				}
				pre++;
			}
			if(tmp > ans) ans = tmp;
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(5&3);
		System.out.println(4&6);
		int t = new lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
		System.out.println(t);
	}
}
