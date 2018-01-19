package coinpurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Noppawan Kulchol
 *
 */
public class Coin implements Comparable<Coin> {
	private double value;
	private String currency;

	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	public double getValue() {
		return this.value;
	}

	public String getCurrency() {
		return this.currency;
	}

	public boolean equals(Object arg) {
		if (arg == null)
			return false;
		if (arg.getClass() != this.getClass())
			return false;
		Coin other = (Coin) arg;
		if (this.currency.equalsIgnoreCase(other.getCurrency()) && this.value == other.getValue())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return value + "-" + currency;
	}

	@Override
	public int compareTo(Coin o) {
		if (this.currency.equals(o.getCurrency())) {
			if (this.value < o.getValue())
				return -1;
			if (this.value > o.getValue())
				return 1;
			if (this.value == o.getValue())
				return 0;
		}
		return this.currency.compareTo(o.getCurrency());
	}
	
	public static void printCoins(List<Coin> coins){
		for(Coin coin : coins){
			System.out.println(coin.getValue()+"-"+coin.getCurrency());
		}
	}
	

	public static void main(String[] args) {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(10.0, "Dollar"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(1.5, "Baht"));
		printCoins(coins);
		Collections.sort(coins);
		System.out.println("==========================================");
		printCoins(coins);
		
	}
	
	
}
