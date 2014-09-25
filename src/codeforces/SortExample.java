package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class SortExample {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Laptop[] laptops = new Laptop[n];
		int i, j;
		for (i = 0; i < n; i++) {
			laptops[i] = new Laptop(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(laptops);
		int min = laptops[0].quality;
		boolean hasil = false;
		for (j = 0; j < n; j++) {
			min = laptops[j].quality;
			for (i = j + 1; i < n; i++) {
				if (min > laptops[i].quality) {
					hasil = true;
					break;
				}
			}
		}
		if (hasil) {
			System.out.println("Happy Alex");
		} else {
			System.out.println("Poor Alex");
		}
		sc.close();
	}

}

class Laptop implements Comparable<Laptop> {
	public int price, quality;

	public Laptop(int price, int quality) {
		this.price = price;
		this.quality = quality;
	}

	@Override
	public int compareTo(Laptop arg0) {
		return this.price - arg0.price;
	}

	@Override
	public String toString() {
		return "price: " + price + " quality: " + quality;
	}
}
