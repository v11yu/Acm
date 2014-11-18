package codeforces.div_2_277;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class D {
	public static void main(String[] args) throws IOException {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		ArrayList<Integer> edge[] = new ArrayList[n];
		int c = 0;
		int ex[] = new int[m];
		int ey[] = new int[m];
		for(int i=0;i<n;i++){
			edge[i] = new ArrayList<Integer>();
		}
		for(int i =0;i<m;i++){
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken());
			int b = Integer.parseInt(tokenizer.nextToken());
			a--;b--;
			ex[i] = a ;
			ey[i] = b;
			if(!exist(a,b,map)){
				edge[a].add(b);
			}
		}
		map.clear();
		for(int i=0;i<m;i++){
			Integer from = ex[i];
			for(Integer to:edge[ey[i]]){
				//System.out.println(from +" "+ey[i]+" "+ to);
				if(from == to) continue;
				exist(from,to,map);
			}
		}
		long ans = 0;
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, Integer> en = iter.next();
			//System.out.println(en.getKey()+" "+en.getValue());
			long t = en.getValue();
			ans += t*(t-1)/2;
		}
		System.out.println(ans);
	}
	public static boolean exist(int a,int b,Map<String, Integer> map){
		String s = a+"#"+b;
		if(map.containsKey(s)){
			map.put(s, map.get(s)+1);
			return true;
		}else{
			map.put(s, 1);
			return false;
		}
	}
}
