package leetcode.problem;
/**
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * @author v11
 */
public class ContainerWithMostWater {
	public int maxArea(int[] h) {
		int l =0,r=h.length-1;
		int res = 0;
		while(l<=r){
			res = Math.max(res, (r-l)*Math.min(h[l], h[r]));
			if(h[l]<h[r]) l++;
			else r--;
		}
		return res;
    }
}
