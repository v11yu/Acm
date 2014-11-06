package leetcode.problem;

public class ReverseWord {
	public String reverseWords(String s) {
		if(s == null) return s;
		String ls[] = s.split(" ");
		String res = "";
		for(int i=ls.length-1;i>=0;i--){
			if(ls[i].trim().length() == 0) continue;
			res += ls[i].trim() +" ";
		}
		return res.trim();
	}
	public static void main(String[] args) {
		String s = new ReverseWord().reverseWords("   a	 	b ");
		System.out.println(s);
	}
}
