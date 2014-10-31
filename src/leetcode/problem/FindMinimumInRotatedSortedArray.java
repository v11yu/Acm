package leetcode.problem;
/**
 * 数据不会重复
 * @author v11
 * @date 2014年10月31日
 * @version 1.0
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
    	int l = 0,r = num.length-1;
    	if(num[l] <= num[r]) return num[l];
    	while(l+1<r){
    		int mid = (l+r)/2;
    		if(num[mid] < num[r]) r = mid;
    		else l = mid;
    	}
		return Math.min(num[l], num[r]);
    }
    public static void main(String[] args) {
		int num[] = {2,3,4,5,6,1};
		System.out.println(new FindMinimumInRotatedSortedArray().findMin(num));
	}
}
