package codeforces.div_2_273;

import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		int num[] = new int[5];
		Scanner cin = new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<5;i++){
			num[i] = cin.nextInt();
			sum +=num[i];
		}
		if(sum % 5 ==0 && sum!=0) System.out.println(sum/5);
		else System.out.println(-1);
	}
}
