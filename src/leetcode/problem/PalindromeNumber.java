package leetcode.problem;
/**
 * https://leetcode.com/problems/palindrome-number/
 * 
 * @author v11
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
	   int p = x;
	   int q = 0;
	   while(p>=10){
		   q *=10;
		   q+= p%10;
		   p/=10;
	   }
	   System.out.println(q);
	   return (x>=0)&&(q == x/10) && (p == x%10);
	}
	public static void main(String[] args) {
		new PalindromeNumber().isPalindrome(1001);
	}
}
