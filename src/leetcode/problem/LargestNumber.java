package leetcode.problem;


import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] tmps) {
		String nums[] = new String[tmps.length];
		for(int i=0;i<tmps.length;i++) nums[i] = tmps[i]+"";
		Arrays.sort(nums, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String tmp1 = o1+o2;
				String tmp2 = o2+o1;
				return tmp2.compareTo(tmp1);
			}
		});
		String res="";
		for(String t:nums){
			//System.out.println(t);
			res +=t;
		}
		if(nums.length>0 && Integer.parseInt(nums[0]) == 0) return "0";
		return res;
    }
	
	public static void main(String[] args) {
		//System.out.println(compare("9","5"));
		//System.out.println(compare("34","3"));
		// TODO Auto-generated method stub
		LargestNumber a= new LargestNumber();
		//int nums[]={26,33,19,29,61,66,52,37,7,76,89,93,72,2,82,11,9,41,47,76,80,28,86,30,99,25,99,85,96,98,88,33,4,94,25,80,19,55,82,71,29,61,15,2,57,98,15,91,27,95,47,38,66,2,78,26,77,33,23,90,73,27,20,5,38,23,35,29,13,46,6,71,58,37,89,28,8,1,8,73,81,83,77,22,63,36,62,89,94,43,25,86,53,21,94,9,40,19,24,21};
		int nums[]={121,12,9};
		//int nums[] = {8248,824};
		System.out.println(a.largestNumber(nums));

	}
}
