package leetcode.problem;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> sta = new Stack<>();
		for(String str:path.split("/")){
			if(str.equals("")||str.equals(".")) ;
			else if(str.equals("..")) sta.pop();
			else sta.push(str);
		}
		String res = "";
		while(!sta.empty()){
			res = "/"+sta.pop()+res;
		}
		return res.equals("")?"/":res;
	}
	public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/abc/..."));
	}
}
