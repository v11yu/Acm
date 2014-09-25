package codeforces.div_2_261;

import java.util.Scanner;

public class C {
    static int n,k,d;
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        k = cin.nextInt();
        d = cin.nextInt();
        boolean ok = false;
        
        int i, j;
        if((d==1 && n>k) || k == 1){
            ok = false;
        }
        else if (check(n,k,d)) {
            ok = true;
        } else {
            ok = false;
        }
        if(n==1) ok = true;
		if (ok) {
			/*
			 * java �����̫���ˡ�һֱWA
			 * ����String���ǲ��С�
			 * ����StringBuilder
			 */
			for (i = 0; i < d ; i++) {
				StringBuilder str = new StringBuilder();
				for (j = 0; j < n; j++) {
					str.append(((j / pow(i, k)) % k) + 1).append(" ");
				}
				System.out.println(str.toString());
			}
			
		}
		else
			System.out.println(-1);
		cin.close();
    }
    public static int pow(int x,int k){
        if(k>1000) return 1;
        int ans = 1;
        while(x-- >0 ){
            if(ans < 1000)ans = ans*k;
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