package leetcode;

public class ShowUtil {
	public static void show(Object[] t){
		System.out.println(t.length );
		for(Object o:t){
			System.out.print(o+" ");
		}
		System.out.println();
	}
	public static void show(boolean[][] t,int w,int l){

		for(int i=0;i<w;i++){
			for(int j=0;j<l;j++){
				System.out.print(t[i][j]+" ");
			}
			System.out.println();
		}
	}
}
