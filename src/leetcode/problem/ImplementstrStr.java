package leetcode.problem;

public class ImplementstrStr {
	public int[] getNext(String needle){
		int next[] = new int[needle.length()+1];
		char str[] = needle.toCharArray();
		int j=0,k=-1;
		next[j] = k;
		while(j<needle.length()){
			if(k == -1 || str[j] == str[k]){
				next[++j] = ++k;
			}
			else k = next[k];
		}
		return next;
	}
	public Integer kmp(String haystack, String needle){
		int next[] = getNext(needle);
		char sr[] = haystack.toCharArray();
		char de[] = needle.toCharArray();
		int i,j;
		for(i=0,j=0;i<sr.length && j<de.length;){
			if(j ==-1 || sr[i] == de[j]){
				j++;
				i++;
			}else{
				j = next[j];
			}
			if(j == de.length){
				return i -de.length;
			}
		}
		if(de.length == 0) return 0;
		else return null;
	}
	public String strStr(String haystack, String needle) {

		Integer pos = kmp(haystack,needle);
		if(pos == null) return null;
		else return haystack.substring(pos);
	}
	public static void main(String[] args) {

		System.out.println(new ImplementstrStr().strStr("", ""));
	}
}
