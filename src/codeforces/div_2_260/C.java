package codeforces.div_2_260;

import java.util.Scanner;

public class C {
	static int[][] ans ;
	static int n,k,d;
	public static void show(){
		for(int i=0;i<d;i++){
			for(int j=0;j<n;j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		k = cin.nextInt();
		d = cin.nextInt();
		ans = new int[d][n];
		boolean ok = false;
		
		int i, j, p;
		int pre = 0;
		if((d==1 && n>k) || k == 1){
			ok = false;
		}
		else if (check(n,k,d)) {
			ok = true;
		} else {
			ok = false;
		}
		for (i = 0; i < d && ok; i++) {
			for (j = 0; j < n; j++) {
				ans[i][j] = (j / (pow(i)) % k) + 1;
			}
		}

		if(ok) show();
		else System.out.println(-1);
	}
	public static int pow(int x){
		int ans = 1;
		while(x-- >0 ){
			if(ans < 1000)ans = ans*2;
			else return 1000;
		}
		return ans;
	}
	public static boolean check(int n,int k,int d){
		int ans = 1;
		if(k>n) return true;
		while(d-->0){
			ans *= k;
			if(ans >= n) return true;
		}
		return false;
	}
}
