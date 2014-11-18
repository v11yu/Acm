package codeforces.div_2_277;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		int n,m;
		int num[] = new int[200];
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		int boy[] = new int[n];
		for(int i=0;i<n;i++){
			boy[i] = cin.nextInt();
		}
		m = cin.nextInt();
		int girl[] = new int[m];
		for(int i=0;i<m;i++){
			girl[i] = cin.nextInt();
		}
		Arrays.sort(boy);
		Arrays.sort(girl);
		int ans =0;
		for(int i=0,j=0;i<n&&j<m;){
			if(Math.abs(boy[i] -girl[j]) <=1){
				ans++;
				i++;
				j++;
			}else if(boy[i]<girl[j]){
				i++;
			}else{
				j++;
			}
		}
		System.out.println(ans);
	}
}
