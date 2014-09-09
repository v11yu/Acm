package codeforces.div_2_265;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = cin.nextInt();
		}
		int ans = 0;
		for(int i=0;i<n;i++){
			if(a[i] == 1){
				if(ans == 0){
					ans ++;
				}
				else if(a[i-1] == 1){
					ans ++;
				}
				else ans+=2;
			}
		}
		System.out.println(ans);
	}
}
