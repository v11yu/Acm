package codeforces.div_2_267;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int q,p;
        int ans = 0;
        for(int i=0;i<n;i++){
            q = cin.nextInt();
            p = cin.nextInt();
            if(q+2 <= p) ans ++;
        }
        System.out.println(ans);
    }
}