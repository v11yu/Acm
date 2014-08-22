package codeforces.div_2_261;

import java.util.Scanner;

public class D {
	
	public static void main(String[] args) {
		int n;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		int a[] = new int[n];
		int num = 0;
		long ans = 0;
		for(int i=0;i<n;i++){
			a[i] = cin.nextInt();
			if(a[i] == i+1) num++;
		}
		int now = 0;
		for(int i=0;i<n;i++){
			if(a[i] == i+1){
				now++;
				num--;
			}
			if(now > num) ans += (n-i);
		}
		System.out.println(ans);
	}
}
