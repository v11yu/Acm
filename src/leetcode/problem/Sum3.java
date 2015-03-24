package leetcode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/3sum/
 * 
 * @author v11
 */
public class Sum3 {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Set<String> set = new HashSet<String>();
		Arrays.sort(num);
		int pre = 0;
		for (int i = 0; i < num.length; i++) {
			int l = i + 1, r = num.length - 1;
			if (i > 0 && pre == num[i])
				continue;
			pre = num[i];
			while (l < r) {
				int sum = num[l] + num[r] + num[i];
				if (sum > 0)
					r--;
				else if (sum == 0) {
					List<Integer> ls = new ArrayList<Integer>();
					String s = num[i] + "" + num[l] + "" + num[r];
					if (!set.contains(s)) {
						ls.add(num[i]);
						ls.add(num[l]);
						ls.add(num[r]);
						res.add(ls);
						set.add(s);
					}
					l++;
				} else
					l++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = { -2, 0, 1, 1, 2 };
		System.out.println(new Sum3().threeSum(a));
	}
}
