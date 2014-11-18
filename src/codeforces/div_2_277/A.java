package codeforces.div_2_277;

import java.util.Arrays;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		int n;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		int num[] = new int[n];
		int nn[] = new int[n];
		int ansx[] = new int[n];
		int ansy[] = new int[n];
		int c =0;
		for(int i=0;i<n;i++){
			num[i] = cin.nextInt();
			nn[i] = num[i];
		}
		Arrays.sort(nn);
		for(int i=0;i<n;i++){
			if(nn[i]!=num[i]){
				int px = find(nn[i],num);
				int py = i;
				int tmp = num[px];
				num[px] = num[py];
				num[py] = tmp;
				ansx[c] = px;
				ansy[c++] = py;
				//System.out.println(px+" "+py);
			}
		}
		System.out.println(c);
		for(int i=0;i<c;i++){
			System.out.println(ansx[i]+" "+ansy[i]);
		}
	}
	public static int find(int n,int num[]){
		for(int i=num.length-1;i>=0;i--){
			if(num[i] == n) return i;
		}
		return 0;
	}
}
