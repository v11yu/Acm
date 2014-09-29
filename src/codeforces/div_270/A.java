package codeforces.div_270;

import java.util.Scanner;

public class A {
    static private int MAX = 1000002;
    static boolean isPrime[];
    static int prime[];
    static int pnum;
    public static void init(){
        pnum = 0;
        prime = new int[MAX];
        isPrime = new boolean[MAX];
        for(int i=0;i<MAX;i++) isPrime[i] = true;
        for(int i=2;i<MAX;i++){
            if(isPrime[i]) prime[pnum++] = i;
            for(int j=0;j<pnum&&prime[j]*i<MAX;j++){
                isPrime[prime[j]*i] = false;
            }
        }
    }
    public static void main(String[] args) {
        init();

        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for(int i=1;i<=n;i++){
            if(!isPrime[i] && !isPrime[n-i]){
                System.out.println(i+" "+(n-i));
                return ;
            }
        }
    }
    
}
