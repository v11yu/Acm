package codeforces.div_2_265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;


public class E {
	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		String s = tokenizer.nextToken();
		tokenizer = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());

		for(int i = 0;i<m;i++){
			tokenizer = new StringTokenizer(reader.readLine());
			String op = tokenizer.nextToken();
			String ls[] = op.split("->");
			//System.out.println(ls.length);
			s = s.replaceAll(ls[0], ls.length==1?"":ls[1]);
		}
		

	}
}
