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
		dfs(0,true);
		if(yes) System.out.println(new String(ss));
		else System.out.println("NO");
		
	}
	/**
	 * 
	 * @param index
	 * @param equal 前缀是否相等。 前缀必须是大于等于
	 */
	public static void dfs(int index,boolean equal){
		if(yes) return ;
		if(index == n ){
			
			if(!equal)yes = true;
			return ;
		}
		
		for(int i=0;i<m&&!yes;i++){
			
			ans[index] = (char) ('a'+i);
			if(equal && ans[index]<ss[index]) continue ;
			if(index > 0 &&ans[index] == ans[index-1]) continue ;
			if(index > 1 &&ans[index] == ans[index-2]) continue ;
			//if(ans[i])
			if(equal && ans[index] == ss[index]) dfs(index+1,true);
			else dfs(index+1,false);
		}
	}

}

