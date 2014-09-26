package codeforces.div_2_260;
import java.util.*;

public class A {

	public static void main(String[] args) {
		int n;
		Scanner cin = new Scanner(System.in);
		n = cin.nextInt();
		Laptop[] laptops = new Laptop[n];
		for (int i = 0; i < n; i++) {
			laptops[i] = new Laptop(cin.nextInt(), cin.nextInt());
		}
		Arrays.sort(laptops);
		boolean happy = false;

		for (int i = 1; i < n; i++) {
			if (laptops[i - 1].quality > laptops[i].quality)
				happy = true;
		}
		if (happy)
			System.out.println("Happy Alex");
		else
			System.out.println("Poor Alex");
		cin.close();
	}
}
class Laptop implements Comparable<Laptop>{
	public int price;
	public int quality;
	public Laptop(int p,int q) {
		this.price = p;
		this.quality = q;
	}

	@Override
	public int compareTo(Laptop o) {
		if(o.price == this.price)
			return o.quality - this.quality;
		return this.price - o.price;
	}
	@Override
	public String toString(){
		return "price "+price
				+" quality " + quality;
	}
	
}
