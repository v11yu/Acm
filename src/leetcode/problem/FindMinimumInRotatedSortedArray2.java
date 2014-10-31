package leetcode.problem;
/**
 * 数据会重复
 * @author v11
 * @date 2014年10月31日
 * @version 1.0
 */
public class FindMinimumInRotatedSortedArray2 {
	public int findMin(int[] num) {
    	return line(num);
    }
	public int line(int[] num){
		int res = Integer.MAX_VALUE;
		for(int i=0;i<num.length;i++){
			res = Math.min(num[i], res);
		}
		return res;
	}
	public int find2(int[] num){
		int l = 0,r = num.length-1;
    	while(l+1<r){
    		int mid = (l+r)/2;
    		if(num[mid] < num[r] ||
    				(num[mid] == num[r] && num[mid] != num[l]))
    			r = mid;
    		else if(num[mid] > num[l] ||
    				(num[mid] == num[l] && num[mid] != num[r]))
    			l = mid;
    		else{
    			// num[mid] == num[l] == num[r]
    		}
    	}
		return Math.min(num[l], num[r]);
	}
	public static void main(String[] args) {
		int num[] = {3,3,1,3};
		System.out.println(new FindMinimumInRotatedSortedArray2().findMin(num));
	}
}
