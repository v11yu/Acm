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
	static int bnum[];
	static int fa[];
	static final long mod = 1000000007;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		e = new List[n];
		color = new int[n];
		mark = new boolean[n];
		dp = new long[n];
		bnum = new int[n];
		fa = new int[n];
		for(int i=0;i<n;i++){
			e[i] = new ArrayList<Integer>();
			mark[i] = false;
			dp[i] = -1;
			bnum[i] = 0;
			fa[i] = -1;
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

		for(int i=0;i<n;i++){
			System.out.print(i+" ");

		}
		System.out.println();
		for(int i=0;i<n;i++){

			System.out.print(dp[i]+" ");
		}
	}
	public static void add(int a,int b){
		e[a].add(b);
		e[b].add(a);
	}
	public static long dfs(int x){
		if(dp[x]!=-1)
			return dp[x];
		bnum[x] = color[x];
		mark[x] = true;
		long r = 1;
		boolean flag = false;
		int c = 0;
		for(Integer node : e[x]){
			if(!mark[node]){
				c++;
				fa[node] = x;
				dfs(node);
				bnum[x] += bnum[node];
			}
		}
		if(c == 0) {
			dp[x] = color[x];
			return dp[x];
		}
		//.. do
		c = 0;
		for(Integer node : e[x]){
			if(node == fa[x]) continue;
			if(dfs(node) != 0){
				r = r*dfs(node) %mod;
				flag = true;
				c++;
			}
		}
		for(Integer node : e[x]){
			if(node == fa[x]) continue;
			if(dfs(node) != 0 && color[x] == 1 && color[node] == 0){
				r = r+ r/dfs(node) * (dfs(node)/bnum[node]);
				r = r%mod;
			}
		}
		if(color[x] == 0) r = r*c % mod;
		if(flag == false && color[x] == 0)
			dp[x] = 0;
		else 
			dp[x] = r%mod;
		return dp[x];
	}
}
