package codeforces.div_270;

import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int num[] = new int[n];
		int ans = 0;
		for(int i=0;i<n;i++){
			num[i] = cin.nextInt();
			num[i] --;
		}
		Arrays.sort(num);
		for(int i=n-1;i>=0;i-=m){
			ans += 2*num[i];
		}
		System.out.println(ans);
	}
}
