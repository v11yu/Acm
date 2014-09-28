package codeforces.div_2_269;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {
	static int nn[],n,m;
	static int mm[],next[];
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer  = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		nn = new int[n];
		mm = new int[m];
		next = new int[m];
		tokenizer = new StringTokenizer(reader.readLine());
		for(int i = 0;i<n;i++){
			nn[i] = Integer.parseInt(tokenizer.nextToken());
		}
		tokenizer = new StringTokenizer(reader.readLine());
		for(int i=0;i<m;i++){
			mm[i] = Integer.parseInt(tokenizer.nextToken());
		}
		if(m == 1){
			System.out.println(n);
			return ;
		}
		for(int i=0;i<n-1;i++){
			nn[i] = nn[i+1]-nn[i];
		}
		n = n-1;
		for(int i=0;i<m-1;i++){
			mm[i] = mm[i+1]-mm[i];
		}
		m = m-1;
		System.out.println(get());
	}
	public static void getNext(){
		int j,k;
		j=0;
		k=-1;
		next[0] = -1;
		while(j<m){
			if(k == -1 || mm[j] == mm[k]){
				next[++j] = ++k;
			}
			else k = next[k];
		}
	}
	public static int get(){
		int ans = 0;
		int i,j=0;
		if(n == 1 && m ==1){
			if(nn[0] == mm[0]) return 1;
			else return 0;
		}
		getNext();
		for(i=0;i<n;i++){
			while(j>0 && nn[i] !=mm[j]){
				j = next[j];
			}
			if(nn[i] == mm[j])
				j++;
			if(j == m){
				ans++;
				j = next[j];
			}
		}
		return ans;
	}
}
