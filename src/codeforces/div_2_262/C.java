package codeforces.div_2_262;

public class C {
	public static void show(){
		
	}
	public static void main(String[] args) {
		int x =3;
		for(int j = x;j<10000;j+=j&(-j)){
			System.out.println(j);
		}
		int y = 7;
		for(int j = y;j>0;j-=j&(-j)){
			System.out.println(j);
		}
	}
}
