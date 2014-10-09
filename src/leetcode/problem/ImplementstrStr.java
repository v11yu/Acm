package leetcode.problem;

public class ImplementstrStr {
	public int[] getNext(String needle){
		int next[] = new int[needle.length()];
		char str[] = needle.toCharArray();
		int j=0,k=-1;
		while(j<needle.length()){
			if(k == -1 || str[j] == str[k]){
				next[++j] = ++k;
			}
		}
		return null;
	}
	public Integer kmp(String haystack, String needle){
		int next[] = getNext(needle);
		return null;
	}
	public String strStr(String haystack, String needle) {

		Integer pos = kmp(haystack,needle);
		if(pos == null) return null;
		else return haystack.substring(pos);
	}
}
