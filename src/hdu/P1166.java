package hdu;

import java.util.Scanner;

/**
 * simple segment tree
 * http://acm.hdu.edu.cn/showproblem.php?pid=1166
 * @author v11
 *
 */
public class P1166 {
	static int maxn = 55555;
	static int sum[] = new int[maxn<<2];
	static void pushUp(int rt) {
		sum[rt] = sum[rt<<1] + sum[rt<<1 | 1]; // need start at 1, not 0
	}
	static public void build(int l,int r,int rt){
		System.out.println(l+" "+r+" "+rt);
		if(l == r) {
			Scanner cin = new Scanner(System.in);
			sum[rt] = cin.nextInt();
			return ;
		}
		int mid = (l+r)>>1;
		build(l,mid,rt<<1);
		build(mid+1,r,rt<<1|1);
		pushUp(rt);
	}
	static public void update(int pos,int val,int l,int r,int rt){
		if(l==r && l==pos) {
			sum[rt] += val;
			return ;
		}
		int mid = (l+r)>>1;
		if(pos <= mid) update(pos,val,l,mid,rt>>1);
		else update(pos,val,mid+1,r,rt>>1|1);
		pushUp(rt);
	}
	static public int query(){
		return maxn;
		
	}
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int T = cin.nextInt();
		for(int cas = 1;cas<=T;cas++){
			System.out.printf("Case %d:",cas);
			int n = cin.nextInt();
			build(1,n,1);
			String op = cin.next();
			int a = cin.nextInt();
			int b = cin.nextInt();
			if(op.charAt(0) == 'Q') System.out.println(query());
			else{
				//if(op.charAt(0)=='A') update();
				//else update();
			}
		}
	}
}
