package codeforces.div_2_273;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		long num[] = new long[3];
		Scanner cin = new Scanner(System.in);
		num[0] = cin.nextLong();
		num[1] = cin.nextLong();
		num[2] = cin.nextLong();
		Arrays.sort(num);
		if(2 * (num[0] + num[1] ) > num[2]){
			long sum = num[0] + num[1] + num[2];
			System.out.println(sum / 3);
		}
		else{
			System.out.println(num[0] + num[1]);
		}
		
	}
}
