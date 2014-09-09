package codeforces.div_2_265;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = 0;
		n = cin.nextInt();
		String str = cin.next();
		int ans = 0;
		for(int i=0;i<n;i++){
			if(str.charAt(i) == '1'){
				ans++;
			}
			else break;
		}
		if(ans < n) ans = ans +1;
		System.out.println(ans);
	}
}
