package codeforces.div_2_261;

import java.util.Scanner;

public class E {
	static int N = 400000;
	static int M = 1000000;
	static int n,m,ne,top,end;
	static int que[],dis[],edge[],head[],weight[],next[];
	static boolean mark[];
	static void init(){
		que = new int[M];
		dis = new int[M];
		edge = new int [M];
		head = new int[N];
		weight = new int[M];
		next = new int[M];
		ne = 1;
		top = 0;
		end = 0;
		mark = new boolean[N];
		for(int i=0;i<N;i++){
			mark[i] = true;
		}
	}
	static void add(int a,int b,int v){
		next[ne] = head[a];
		head[a] = ne;
		weight[ne] = v;
		edge[ne++] = b;
	}
	static Integer dp(){
		for(int i=1 ;i<=n;i++){
			que[end++] = i;
		}
		while(top<end){
			int x = que[top++];
			mark[x] = false;
			for(int i = head[x];i>0;i=next[i]){
				int to = edge[i];
				int v = weight[i];
				//if()
				if(!mark[to]){
					mark[to] = true;
					que[end++] = to;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		init();
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		for(int i=0;i<m;i++){
			int a,b,v;
			a = cin.nextInt();
			b = cin.nextInt();
			v = cin.nextInt();
			add(a,b,v);
		}
		System.out.println(dp());
	}
}
