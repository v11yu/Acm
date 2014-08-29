package codeforces.div_2_261;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static Integer Max = 1000002;
	public static Integer add(HashMap<Integer, Integer> map,Integer key,Integer addV){
		Integer v = 0;
		if(map.containsKey(key)){
			v = map.get(key);
		}
		map.put(key, v+addV);
		return map.get(key);
	}
	public static void main(String[] args) {
		int n;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		int a[] = new int[n];
		int dp[] = new int[n];
		int rdp[] = new int[n];
		int st[] = new int[Max];
		int num = 0;
		long ans = 0;
//		for(int i=0;i<Max;i++){
//			st[i] = 0;
//		}
		for(int i=0;i<n;i++){
			a[i] = cin.nextInt();
			dp[i] = add(map,a[i],1);
		}
		map.clear();
		for(int i=n-1 ;i>=0;i--){
			rdp[i] = add(map,a[i],1);
		}
		for(int i=0;i<n;i++){
			for(int j=rdp[i];j<Max;j+=j&(-j)){
				st[j]++;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=rdp[i];j<Max;j+=j&(-j)){
				st[j]--;
			}
			for(int j=dp[i]-1;j>0;j-=j&(-j)){
				ans += st[j];
			}
		}
		System.out.println(ans);
	}
}
