package leetcode;

import java.util.Scanner;

import leetcode.model.ListNode;

public class Test {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String str = cin.next();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A') {
				System.out.print('1');
			}
			if (str.charAt(i) == 'B') {
				System.out.print('2');
			}
			if (str.charAt(i) == 'C') {
				System.out.print('$');
			}
			if (str.charAt(i) == 'D') {
				System.out.println();
			}
		}
	}
}
