package codeforces.div_2_263;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
	static List<Integer> e[];
	static int color[];
	static boolean mark[];
	static int n;
	static long dp[];
	static long bnum[];
	static final long mod = 1000000007;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		e = new List[n];
		color = new int[n];
		mark = new boolean[n];
		dp = new long[n];
		bnum = new long[n];

		for(int i=0;i<n;i++){
			e[i] = new ArrayList<Integer>();
			mark[i] = false;
		}
		int l = 0;
		for(int i=0;i<n-1;i++){
			l = cin.nextInt();
			add(i+1,l);
		}
		for(int i=0;i<n;i++){
			color[i] = cin.nextInt();
		}
		
		System.out.println(dfs(0));

	}
	public static void add(int a,int b){
		e[a].add(b);
		e[b].add(a);
	}
	public static long dfs(int x){
		if(color[x] == 1){
			dp[x] = 1;
			bnum[x] = 0;
		}
		else{
			bnum[x] = 1;
			dp[x] = 0;
		}
		mark[x] = true;
		for(Integer node : e[x]){
			if(!mark[node]){
				dfs(node);
				dp[x] = (dp[x]*bnum[node] + dp[node]*bnum[x] + dp[x] * dp[node] )%mod;
				bnum[x] = bnum[x] *(bnum[node] + dp[node]) %mod;
			}
		}
		return dp[x];
	}
}
