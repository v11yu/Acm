package codeforces.div_2_267;

import java.util.Scanner;


public class C {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int k = cin.nextInt();
        int num[] = new int[n+1];
        long sum[] = new long[n+1];
        for(int i=1;i<=n;i++){
            num[i]= cin.nextInt();
            sum[i] = sum[i-1] + num[i];
        }
        long ans = 0;

		long dp[] = new long[n + 1];
		for (int i = 0; i < k; i++) {
			for (int j = n; j >= m; j--) {
				long t = sum[j] - sum[j - m];
				dp[j] = Math.max(dp[j], dp[j - m] + t);
			}
			for (int j = 1; j <= n; j++) {
				dp[j] = Math.max(dp[j], dp[j - 1]);
			}
		}

		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
		cin.close();
    }
}
