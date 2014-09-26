package leetcode.problem;

public class LongestValidParentheses {
	private void markString(String s,boolean m[]){
		int sta[] = new int[s.length()];
		int top = 0;
		for(int i=0;i<s.length();i++){
			m[i] = false;
			if(s.charAt(i) == '(') sta[top++] = i;
			else if(top > 0){
				m[sta[--top]] = true;
			}
		}
	}
	public int longestValidParentheses(String s) {
		boolean m[] = new boolean[s.length()];
		int num = 0,len = 0,ans = 0;
		markString(s,m);
		for(int i=0;i<s.length();i++){
			if(s.charAt(i) == '('){
				if(m[i])num++;
				else len = 0;
			}
			else{
				if(num > 0){
					num--;
					len += 2;
					ans = Math.max(ans, len);
				}
				else len = 0;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int len = new LongestValidParentheses().longestValidParentheses("()(()");
		System.out.println(len);
	}
}
