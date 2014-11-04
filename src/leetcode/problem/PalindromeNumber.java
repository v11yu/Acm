package leetcode.problem;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		return check(x);
	}
	public boolean check(int num){
		if(num<0) return false;
		int pow10[] = new int[10];
		init(pow10,10);
		int len = getLenth(num);
		for(int i=0;i<len;i++){
			if(getPosNum(i,num,pow10) != getPosNum(len-1-i,num,pow10)) return false;
		}
		return true;
		
	}
	private void init(int n[],int d){
		n[0] = 1;
		for(int i=1;i<n.length;i++) n[i] = n[i-1] *10;
	}
	private int getPosNum(int pos,int x,int pow10[]){
		return (x/pow10[pos])%10;
	}
	private int getLenth(int x){
		int res = 0;
		while(x!=0){x/=10;res++;}
		return res;
	}
	public boolean check(String str){
		for(int i=0;i<str.length();i++){
    		if(str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
    	}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new PalindromeNumber().check(10010));
	}
}
