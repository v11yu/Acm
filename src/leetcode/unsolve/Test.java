package leetcode.unsolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.model.Point;

public class Test {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Set<String> st = new HashSet<String>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for (int l = 0; l < num.length; l++) {
			for (int r = num.length - 1; r > l; r--) {
				int sum = num[l] + num[r];
				int abs = Integer.MAX_VALUE;
				for (int ll = l + 1, rr = r - 1; ll < rr;) {
					sum = num[l] + num[r] + num[ll] + num[rr];
					if (Math.abs(sum - target) < Math.abs(abs))
						abs = sum - target;
					if (sum > target)
						rr--;
					else if (sum < target)
						ll++;
					else {
						List<Integer> t = new ArrayList<Integer>();
						String tmp = num[l] + "" + num[ll] + "" + num[rr]
								+ num[r];
						if (!st.contains(tmp)) {
							t.add(num[l]);
							t.add(num[ll]);
							t.add(num[rr]);
							t.add(num[r]);
							res.add(t);
							st.add(tmp);

						}
						ll++;
					}
				}
				if (abs > 0)
					r--;
				else
					l++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int ls[] = { 1, 0, -1, 0, -2, 2 };
		System.out.println(new Test().fourSum(ls, 0));
	}
}
