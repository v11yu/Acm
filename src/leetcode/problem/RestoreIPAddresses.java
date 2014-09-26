package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	private List<String> res;
	private int segs[];

	public List<String> restoreIpAddresses(String s) {//12
		res = new ArrayList<String>();
		segs = new int[4];
		dfs(s,0,0);
		return res;
	}
	private void dfs(String str,int seg,int len){
		String ans ="";
		if(seg == 3){
			segs[seg] = str.length();
			int pre = 0;
			for(int i =0;i<segs.length;i++){
				int val = Integer.parseInt(str.substring(pre, segs[i]));
				if(val >=256 || Integer.toString(val).length() != str.substring(pre, segs[i]).length()) return ;
				ans = ans +val;
				if(i+1<segs.length) ans+='.';
				pre = segs[i];
			}
			//System.out.println(ans);
			res.add(ans);
			return ;
		}
		for(int i=1;i<=3;i++){
			segs[seg] = len+i;
			if((str.length() -len - i) <= (3-seg)*3 && (str.length() -len - i)>0){
				dfs(str,seg+1,len+i);
			}
		}
		
	}
	public static void main(String[] args) {
		new RestoreIPAddresses().restoreIpAddresses("010010");
	}
}
