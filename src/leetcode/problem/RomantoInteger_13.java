package leetcode.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 
 * @author v11
 */
public class RomantoInteger_13 {
	private static final Map<Character, Integer> maps = new HashMap<>();
    static{
        maps.put('I', 1);
        maps.put('V', 5);
        maps.put('X', 10);
        maps.put('L', 50);
        maps.put('C', 100);
        maps.put('D', 500);
        maps.put('M', 1000);
    }
	public int romanToInt(String s) {
		int res = 0;
		int pre = maps.get(s.charAt(0));
		for(int i=0;i<s.length();i++){
			int cur = maps.get(s.charAt(i));
			res += cur;
			if(pre<cur) res -= pre*2;
			pre =cur;
		}
		return res;
	}
}
