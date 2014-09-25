package codeforces.div_2_263;

import java.util.Arrays;
import java.util.Scanner;

public class B {
	static int a[] = new int[26];
	static int n,k;
	static String str ;
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		k = cin.nextInt();
		str = cin.next();
		for(int i=0;i<26;i++){
			a[i] = 0;
		}
		for(int i=0;i<n;i++){
			int c = str.charAt(i) - 'A';
			a[c] ++;
		}
		Arrays.sort(a);
		long ans = 0;
		long num = 0;
		for(int i=25;i>=0;i--){
			if(a[i] >= k){
				num = k;
				ans += num*num;
				break;
			}
			else {
				k -= a[i];
				num = a[i];
				ans += num*num;
			}
		}
		System.out.println(ans);
		cin.close();
	}
}
