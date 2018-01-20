package coinpurse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Coin that show its value and currency.
 * @author Noppawan Kulchol
 *
 */
public class Coin implements Comparable<Coin> {
	private double value;
	private String currency;
	
	/**
	 * Initialize value and currency of coins.
	 * @param value is value of each coins.
	 * @param currency is currency of each coins.
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get the value of coins.
	 * @return value of coins.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of coins.
	 * @return currency of coins.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * Check value and currency of coins that it equals to the other or not.
	 * If they have the same value and same currency it return true.
	 */
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

	/**
	 * toString return the value and currency of coins.
	 * @return the value and currency of coins.
	 */
	@Override
	public String toString() {
		return value + "-" + currency;
	}

	/**
	 * Order coins by value so that smaller value of coins come first and ignore currency.
	 * @return ordered coins value.
	 */
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
	
	/**
	 * Print value and currency of coins
	 * @param coins are coins in the list.
	 */
	public static void printCoins(List<Coin> coins){
		for(Coin coin : coins){
			System.out.println(coin.getValue()+"-"+coin.getCurrency());
		}
	}
	

	/**
	 * run the program for check printCoins method and compareTo method.
	 * @param args
	 */
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
