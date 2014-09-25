package codeforces.div_2_262;

import java.util.Scanner;
public class C {
	public static void show(){
		
	}
	public static void main(String[] args) {
		int n,k;
		long m;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		m = cin.nextLong();
		k = cin.nextInt();
		int a[] = new int[n];
		long s[] = new long[n+1];
		for(int i=0;i<n;i++){
			a[i] = cin.nextInt();
		}
		long low = 0,high = 1100000000;

		while(low + 1 < high){
			//System.out.println(low+" "+high);
			long mid = (low+high)/2;
			long cur = 0,sum =0 ,t;
			//s[n-1] = 0;//clear
			for(int i=0;i<n;i++){
				cur -= s[i];
				t = Math.max(mid - (cur+a[i]),0);
				sum += t;
				cur += t;
				s[Math.min(n, i+k)] = t;
			}
			if(sum > m){
				high = mid;
			}
			else{
				low = mid;
			}
		}
		System.out.println(low);
		cin.close();
	}
}
