package codeforces.div_2_261;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		int n;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i] = cin.nextInt();
		}
		int Max = a[0] ,Min = a[0];
		for(int i=0;i<n;i++){
			if(a[i] > Max) Max = a[i];
			if(a[i] < Min) Min = a[i];
		}
		long min_c=0,max_c=0;
		for(int i=0;i<n;i++){
			if(a[i] == Max) max_c++;
			if(a[i] == Min) min_c++;
		}
//		max_c = 1000000000;
//		min_c = 1000000000;
		if(Max !=Min)
			System.out.println(Max-Min+" "+max_c*min_c);
		else 
			System.out.println(Max-Min+" "+max_c*(min_c-1)/2);
	}
}
