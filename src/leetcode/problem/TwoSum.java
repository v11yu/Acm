package leetcode.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int res[]={0,0};
		Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
		for(int i=0;i<numbers.length;i++){
			mp.put(numbers[i],i);
		}
		for(int i=0;i<numbers.length;i++){
			int num = numbers[i];
			int tmp = target-num;
			if(mp.containsKey(tmp) && mp.get(tmp)!=i){
				res[0] = i+1;
				res[1] = mp.get(tmp)+1;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
