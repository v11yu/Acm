package codeforces.div_2_273;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		long a = cin.nextLong();
		long b = cin.nextLong();
		long c = a/b;
		long Min = ((c + 1) * c / 2) * (a%b)  + (c*(c-1)/2)*(b - a%b);
		long Max = (a-b+1) * (a-b) /2;
		System.out.println(Min+" "+Max);
	}
}
