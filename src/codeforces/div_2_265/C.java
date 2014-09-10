package codeforces.div_2_265;

import java.util.Scanner;

public class C {
	static int n,m;
	static char ss[];
	static char ans[];
	static boolean yes = false;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextInt();
		ss = new char[n];
		String str = cin.next();
		ss = str.toCharArray();
		ans = str.toCharArray();
		dfs(0);
		if(yes) System.out.println(new String(ss));
		else System.out.println("NO");
		
	}
	public static void dfs(int index){
		if(yes) return ;
		if(index == n){
			yes = true;
			return ;
		}
		for(int i=0;i<m;i++){
			ans[i] = (char) ('a'+i);
			//if(ans[i])
			dfs(i+1);
		}
	}

}

