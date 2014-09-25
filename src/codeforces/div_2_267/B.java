package codeforces.div_2_267;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        int n,m,k;
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        k = cin.nextInt();
        int num[] = new int[m+1];
        for(int i=0;i<=m;i++){
            num[i] = cin.nextInt();
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            if(ok(num[i],num[m],k))
                ans ++;
        }
        System.out.println(ans);
        cin.close();
    }
    public static boolean ok(Integer x,Integer y,int k){
        Integer res = x^y;
        int c = 0;
        String str = Integer.toString(res,2);
        for(int i=0;i<str.length();i++){
        	if(str.charAt(i) == '1') c++; 
        }
        if(c>k) return false;
        return true;
    }
}
