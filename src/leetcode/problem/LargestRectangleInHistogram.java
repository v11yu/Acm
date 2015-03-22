package leetcode.problem;
/**
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] h) {
		int l[] = new int[h.length];
		int r[] = new int[h.length];
		int st[] = new int[h.length];
		int c=0,res=0,i;
		for(i=0;i<h.length;i++){
			while(c != 0 && h[st[c-1]]>h[i]) c--;
			l[i] = c == 0?-1:st[c-1];
			System.out.println(l[i]);
			st[c++] = i;
		}
		for(i=h.length-1,c=0;i>=0;i--){
			while(c != 0 && h[st[c-1]]>h[i]) c--;
			r[i] = c == 0?h.length:st[c-1];
			System.out.println(r[i]);
			res = Math.max(res, (r[i]-l[i]-1)*h[i]);
			st[c++] = i;
		}
		return res;
	}
	public static void main(String[] args) {
		int b[] = {2,4};
		System.out.println(new LargestRectangleInHistogram().largestRectangleArea(b));
	}
}
