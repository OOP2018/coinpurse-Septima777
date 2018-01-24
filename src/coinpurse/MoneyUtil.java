package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

/**
 * This class there are 2 method sortCoins, sort coins, and filterByCurrency,
 * find the coins that are same currency.
 * 
 * @author Noppawan Kulchol
 *
 */
public class MoneyUtil {

	/**
	 * Sort coins in the list.
	 * @param coins are coins in the list.
	 */
	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}

	/**
	 * Find the coins that are same currency and get them to the new list.
	 * @param coins are coins in the list.
	 * @param currency is currency of coins.
	 * @return the list of the coins with same currency.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> sameCurrency = new ArrayList<>();
		for (Coin coin : coins) {
			if (coin.getCurrency().equals(currency)) {
				sameCurrency.add(coin);
			}
		}
		return sameCurrency;
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
		coins.add(new Coin(10.0, "ht"));
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(1.5, "Baht"));
		printCoins(coins);
		Collections.sort(coins);
		System.out.println("==========================================");
		printCoins(coins);
		System.out.println("==========================================");
		System.out.println(filterByCurrency(coins, "ht"));
		
	}
}
