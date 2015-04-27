package leetcode.problem;
import java.util.*;
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		
		Rec(num, result, temp, 0);
		return result;
	}

	private static void Rec(int[] a, List<List<Integer>> result,
			LinkedList<Integer> temp, int current) {
		result.add(new LinkedList(temp));
		// 当数组是{1,1',3}时,担心出现{1,3}和{1’,3},以temp == 0为开头，就不会添加1'
		for (int i = current; i < a.length; i++) {
			//通过 a[i]!=a[i-1] 避免了，{1,3,3,3，4} 我们从1出发，仅仅会添加一次的{1,3,*}
			if (i == current || a[i] != a[i - 1]) {
				temp.add(a[i]);
				Rec(a, result, temp, i + 1);
				temp.remove(temp.size() - 1);
			}
		}
		return;
	}
	public static void main(String[] args) {
		int num[] = {1,2};
		new SubsetsII().subsetsWithDup(num);
	}
}
