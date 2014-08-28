package codeforces.div_2_263;

import java.util.Scanner;

public class A {
	static int n;
	static String[] maps;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	public static void main(String[] args) {
		
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		maps = new String[n];
		for(int i=0;i<n;i++){
			maps[i] = cin.next();
		}
		if(check()) System.out.println("YES");
		else System.out.println("NO");
	}
	public static boolean check(){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int num = 0;
				for(int k=0;k<dx.length;k++){
					int x = i + dx[k];
					int y = j + dy[k];
					if(over(x,y) && maps[x].charAt(y) == 'o'){
						num++;
					}
				}
				if(num%2 == 1) return false;
			}
		}
		return true;
	}
	public static boolean over(int x,int y){
		if(x>=0&&x<n&&y>=0&&y<n)
			return true;
		return false;
	}
}
