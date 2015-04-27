package leetcode.problem;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * 
 * @author v11
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		if(s==null||p==null) return false;
		int ss=0,pp=0,ppre=-1,spre=-1;
		p=p+'^';
		while(ss<s.length()&&pp<p.length()){
			char c1 = s.charAt(ss),c2 = p.charAt(pp);
			if( c1==c2  || c2=='?'){ ss++;pp++;}
			else if(c2 == '*'){ ppre = ++pp;spre = ss;}
			else{
				if(ppre == pp) {ss++;spre++;}
				else{
					if(ppre !=-1){
						pp = ppre;
						ss = spre+1;
						spre++;
					}
					else return false;
				}
			}
		}
		if(ss<s.length()) return false;
		while(pp<p.length()-1){
			if(p.charAt(pp++) !='*') return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "abcdefdefg";
		String p = "abc*def";
		System.out.println(new WildcardMatching().isMatch(s, p));
	}
}
