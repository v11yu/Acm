package leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 * 
 * @author v11
 */
public class SubstringAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		List<Integer> res = new ArrayList<Integer>();
		if(S==null || L == null || L.length ==0) return res;
		Map<String, Integer> mp = new HashMap<String, Integer>();
		for(int i =0;i<L.length;i++){
			mp.put(L[i], !mp.containsKey(L[i])?1:mp.get(L[i])+1);
		}
		int len = L[0].length();
		int size = len*L.length;
		for(int i=0;i+size<=S.length();i++){
			Map<String, Integer> mp1 = new HashMap<String, Integer>();
			for(int j=i;j<i+size;j+=len){
				String str = S.substring(j, j+len);
				if(!mp.containsKey(str)) break;
				mp1.put(str, !mp1.containsKey(str)?1:mp1.get(str)+1);
			}
			if(mp1.equals(mp)) res.add(i);
		}
		return res;
	}
	public static void main(String[] args) {
		Map<String, Integer> mp1 = new HashMap<String, Integer>();
		Map<String, Integer> mp2 = new HashMap<String, Integer>();
		mp1.put("1",3);
		mp2.put("1", 1);
		if(mp1.equals(mp2)) System.out.println(1);
	}
}
