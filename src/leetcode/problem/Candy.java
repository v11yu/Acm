package leetcode.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://oj.leetcode.com/problems/candy/
 * 
 * @author v11
 */
public class Candy {

	public int candy(int[] ratings) {
		int dp[] = new int[ratings.length];
		Pair p[] = new Pair[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			p[i] = new Pair(ratings[i], i);
			dp[i] = 1;
		}
		Arrays.sort(p);
		for (int i = 0; i < ratings.length; i++) {

			int pos = p[i].pos;
			int l = p[i].pos - 1;
			int r = p[i].pos + 1;
			if (l >= 0 && ratings[l] > ratings[pos])
				dp[l] = Math.max(dp[pos] + 1, dp[l]);
			if (r < ratings.length && ratings[r] > ratings[pos])
				dp[r] = Math.max(dp[pos] + 1, dp[r]);

		}
		int res = 0;
		for (int i = 0; i < ratings.length; i++) {
			res += dp[i];
		}
		return res;
	}

	class Pair implements Comparable<Pair> {
		int v, pos;

		public Pair(int v, int p) {
			this.v = v;
			this.pos = p;
		}

		@Override
		public String toString() {
			return "Pair [v=" + v + ", pos=" + pos + "]";
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.v < o.v)
				return -1;
			return 1;
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 4, 3, 2, 5 };
		new Candy().candy(a);
	}
}
