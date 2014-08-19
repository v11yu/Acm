package codeforces.div_2_260;

import java.util.Scanner;



public class A {
	static int x1,x2,y1,y2,x3=1,y3=1,x4=1,y4=1;
	public static int dis(int a,int aa,int b,int bb){
		return (a-b)*(a-b) + (aa-bb)*(aa-bb);
	}
	public static boolean check(int a,int aa,int b,int bb,int c,int cc){
		int d = dis(a,aa,b,bb);
		int dd = dis(b,bb,c,cc);
		return (d==dd);
	}
	public static boolean checkRange(int x){
		if(x>=-1000 && x<=1000)
			return true;
		return false;
	}
	public static void swap(int a,int b){
		int tmp = a;
		a= b;
		b=tmp;
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		
		x1 = cin.nextInt();
		y1 = cin.nextInt();
		x2 = cin.nextInt();
		y2 = cin.nextInt();
		if(x1>x2){
			swap(x1,x2);
			swap(y1,y2);
		}
		boolean ans = false;
		//1
		if(x1 == x2){
			int d =  y2-y1;
			y3 = y1;
			x3 = x1 + d;
			x4 = x1 + d;
			y4 = y2;
			int dd = dis(x3,y3,x4,y4);
			if(dd == d*d)
				ans = true;
		}
		else if(y1 == y2){
			int d =  x2-x1;
			y3 = y1+ d;
			x3 = x1 ;
			x4 = x2 ;
			y4 = y2 + d;
			int dd = dis(x3,y3,x4,y4);
			if(dd == d*d)
				ans = true;
		}
		else{
			
			y3 = y1;
			x3 = x2;
			x4 = x1;
			y4 = y2;

			if(Math.abs(x2-x1) == Math.abs(y2-y1)) ans = true;
		}
		if(ans)
			System.out.println(x4+" "+y4+" "+x3+" "+y3);
		else 
			System.out.println(-1);
	}
}

