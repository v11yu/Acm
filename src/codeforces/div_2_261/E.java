package codeforces.div_2_261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class E {
	static int n,m,dp[],que[],dp2[];
	static int M = 500000;
	public static void main(String[] args) throws IOException {
		
		/*
		 * ÈÝÒ×³¬Ê±
		 */
		//Scanner cin = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());;
		m = Integer.parseInt(tokenizer.nextToken());;
		Edge e[] = new Edge[m];
		dp = new int[M];
		dp2 = new int[M];
		que = new int[M];
		for(int i=0;i<m;i++){
			e[i] = new Edge();
		}
		for(int i=0;i<m;i++){
			
			tokenizer = new StringTokenizer(reader.readLine());
			e[i].from = Integer.parseInt(tokenizer.nextToken());
			e[i].to = Integer.parseInt(tokenizer.nextToken());
			e[i].v = Integer.parseInt(tokenizer.nextToken());
			//System.out.println(e[i].from);
		}
		Arrays.sort(e);
		int max = 0 , top = 0,end = 0;;
		int pre = -1;
		for (int i = 0; i < m; i++) {
			if (pre != e[i].v) {
				while (top < end) {
					int x = que[top++];
					dp[x] = dp2[x];
				}
			}
			que[end++] = e[i].to;
			dp2[e[i].to] = Math.max(dp2[e[i].to], dp[e[i].to]);
			dp2[e[i].to] = Math.max(dp2[e[i].to], dp[e[i].from] + 1);
			pre = e[i].v;

		}
		while (top < end) {
			int x = que[top++];
			dp[x] = dp2[x];
		}
		for(int i=1;i<=n;i++){
			max = Math.max(max,dp[i]);
		}
		System.out.println(max);
	}
	
}
class Edge implements Comparable<Edge>{
	int to,v,from;
	public int compareTo(Edge o) {
		return v - o.v;
	}
}
