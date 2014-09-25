package codeforces.div_2_262;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		int a,b,c;
		long mm = 1000000000;
		Scanner cin = new Scanner(System.in);
		a = cin.nextInt();
		b = cin.nextInt();
		c = cin.nextInt();
		int ans = 0;
		long d[] = new long[100];
		for(int i=1;i<=81;i++){
			long y = b;
			int t = a;
			while(t-->0){
				y = y*i;
			}
			y += c;
			//System.out.println(i+" "+y);
			int x = get(y);
			if(x == i&&y<=mm){
				d[ans++] = y;
			}
		}
		System.out.println(ans);
		for(int i=0;i<ans;i++){
			System.out.print(d[i]+" ");
		}
		cin.close();
	}
	public static int get(long y){
		int res = 0;
		while(y>0){
			res += y % 10;
			y/=10;
		}
		return res;
	}
}
