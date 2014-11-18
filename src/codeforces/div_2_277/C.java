package codeforces.div_2_277;

import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		if(n == 1 && m == 0){
			System.out.println("0 0");
			return ;
		}
		if(m == 0 || n*9 < m){
			System.out.println("-1 -1");
			return ;
		}
		//min
		String s = "";
		for(int i=0,tmp = m-1;i<n;i++){
			if(i == n-1){
				s+=(tmp+1);
				break;
			}
			if(tmp > 9){
				s+=9;
				tmp-=9;
			}else{
				s+=tmp;
				tmp-=tmp;
			}
		}
		for(int i=s.length()-1;i>=0;i--){
			System.out.print(s.charAt(i));
		}
		System.out.print(" ");
		//max
		
		for(int i=0,tmp = m;i<n;i++){
			if(tmp > 9){
				System.out.print(9);
				tmp-=9;
			}else{
				System.out.print(tmp);
				tmp-=tmp;
			}
		}
		System.out.println();
		//101111
		//m00000
		
		
	}
}
