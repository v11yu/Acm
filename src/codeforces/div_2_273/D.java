package codeforces.div_2_273;

import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int a = cin.nextInt();
		int b = cin.nextInt();
		int h = findH(a+b);
	}
	public static int findH(int t){
		int res = 0;
		if(t == 0) return 0;
		for(int i=1;i<1000;i++){
			if(i*(i+1)/2 > t)
				return i-1;
		}
		return res;
	}
}
