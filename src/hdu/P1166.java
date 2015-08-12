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
	static public int left(int x){return x<<=1;}
	static public int right(int x){return (x<<=1) | 1;}
	static Scanner cin = new Scanner(System.in);
	static public void build(int l,int r,int rt){
		//System.out.println(l+" "+r+" "+rt);
		if(l == r) {
			sum[rt] = cin.nextInt();
			//System.out.println(rt + " "+ sum[rt]);
			return ;
		}
		int mid = (l+r)>>1;
		build(l,mid,left(rt));
		build(mid+1,r,right(rt));
		pushUp(rt);
	}
	static public void update(int pos,int val,int l,int r,int rt){
		if(l==r && l==pos) {
			sum[rt] += val;
			return ;
		}
		int mid = (l+r)>>1;
		if(pos <= mid) update(pos,val,l,mid,left(rt));
		else update(pos,val,mid+1,r,right(rt));
		pushUp(rt);
	}
	static public int query(int L,int R,int l,int r,int rt){
		if(L<=l && R>=r){
			return sum[rt];
		}
		int mid = (l+r)>>1;
		int ret = 0;
		if(L<=mid) ret += query(L,R,l,mid,left(rt));
		if(R>mid) ret += query(L,R,mid+1,r,right(rt));
		return ret;
		
	}
	public static void main(String[] args) {
		int T = cin.nextInt();
		for(int cas = 1;cas<=T;cas++){
			System.out.printf("Case %d:\n",cas);
			int n = cin.nextInt();
			build(1,n,1);
			while(true){
				String op = cin.next();
				if(op.charAt(0) == 'Q'){
					int a = cin.nextInt();
					int b = cin.nextInt();
					System.out.println(query(a,b,1,n,1));
				}
				else if(op.charAt(0) == 'E') break;
				else{
					int a = cin.nextInt();
					int b = cin.nextInt();
					if(op.charAt(0)=='A') update(a,b,1,n,1);
					else update(a,-b,1,n,1);
				}
			}
		}
	}
}
