package codeforces.div_2_269;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int cnt[] = new int[3000];
		Num num[] = new Num[n];
		for(int i=0;i<n;i++){
			num[i] = new Num();
			num[i].pos = i+1;
			num[i].v = cin.nextInt();
			map.put(num[i].v, 1);
			cnt[num[i].v]++;
		}
		if(map.size() > n-2){
			System.out.println("NO");
			return ;
		}
		Arrays.sort(num);
		System.out.println("YES");
		for(int i=0;i<n;i++){
			System.out.print(num[i].pos+" ");
		}
		System.out.println();
		for(int i=1;i<n;i++){
			if(num[i].v == num[i-1].v){
				Num.swap(num[i], num[i-1]);
				break;
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(num[i].pos+" ");
		}
		System.out.println();
		int cc = 0;
		for(int i=1;i<n;i++){
			if(num[i].v == num[i-1].v){
				if(cc == 0){
					cc++;
					continue;
				}
				Num.swap(num[i], num[i-1]);
				break;
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(num[i].pos+" ");
		}
		System.out.println();
	}
}
class Num implements Comparable<Num>{
	int v,pos;
	@Override
	public int compareTo(Num o) {
		// TODO Auto-generated method stub
		return this.v - o.v;
	}
	public static void swap(Num a,Num b){
		int t = a.pos;
		a.pos = b.pos;
		b.pos = t;
	}
}
