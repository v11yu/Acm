package leetcode.problem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<>();
		for(String s:tokens){
			if(s.equals("*")){
				int sec = st.pop();
				int fir = st.pop();
				st.push(fir*sec);
			}else if(s.equals("-")){
				int sec = st.pop();
				int fir = st.pop();
				st.push(fir-sec);
			}else if(s.equals("+")){
				int sec = st.pop();
				int fir = st.pop();
				st.push(fir+sec);
			}else if(s.equals("/")){
				int sec = st.pop();
				int fir = st.pop();
				st.push(fir/sec);
			}else{
				st.add(Integer.parseInt(s));
			}
		}
		return st.pop();
	}
}
