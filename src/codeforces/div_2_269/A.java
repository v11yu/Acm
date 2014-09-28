package codeforces.div_2_269;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		int num[] = new int[10];
		Scanner cin = new Scanner(System.in);
		for(int i=0;i<6;i++){
			Integer n = cin.nextInt();
			num[n]++;
		}
		boolean hasFour = false;
		for(int i=0;i<10;i++){
			if(num[i] >= 4) {
				num[i] -= 4;
				hasFour = true;
			}
		}
		if(!hasFour){
			System.out.println("Alien");
			return ;
		}
		boolean hasTwo = false;
		for(int i=0;i<10;i++){
			if(num[i] >= 2) {
				hasTwo = true;
			}
		}
		if(!hasTwo){
			System.out.println("Bear");
		}
		else{
			System.out.println("Elephant");
		}
	}
}
