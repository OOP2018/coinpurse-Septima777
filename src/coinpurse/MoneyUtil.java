package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

/**
 * This class there are 2 method sortCoins, sort money, and filterByCurrency,
 * find the money that are same currency.
 * 
 * @author Noppawan Kulchol
 *
 */
public class MoneyUtil {

	/**
	 * Sort coins in the list.
	 * @param valuables are coins and bank note in the list.
	 */
	public static void sortCoins(List<Valuable> valuables) {
		Collections.sort(valuables);
	}

	/**
	 * Find the money that are same currency and get them to the new list.
	 * @param value are money in the list.
	 * @param currency is currency of money.
	 * @return the list of the coins with same currency.
	 */
	public static List<Valuable> filterByCurrency(List<Valuable> value, String currency) {
		List<Valuable> sameCurrency = new ArrayList<Valuable>();
		for (Valuable valuable : value) {
			if (valuable.getCurrency().equals(currency)) {
				sameCurrency.add(valuable);
			}
		}
		return sameCurrency;
	}

	/**
	 * Print value and currency of money
	 * @param vList are money in the list.
	 */
	public static void printValue(List<Valuable> vList){
		for(Valuable value : vList){
			System.out.println(value.getValue()+"-"+value.getCurrency());
		}
	}
	

	/**
	 * run the program for check printCoins method and compareTo method.
	 * @param args
	 */
	public static void main(String[] args) {
		List<Valuable> value = new ArrayList<Valuable>();
		value.add(new Coin(10.0, "ht"));
		value.add(new BankNote(50.0, "Baht"));
		value.add(new BankNote(20.0, "Baht"));
		value.add(new Coin(1.5, "Baht"));
		printValue(value);
//		Collections.sort(value);
		sortCoins(value);
		System.out.println("==========================================");
		printValue(value);
		System.out.println("==========================================");
		System.out.println(filterByCurrency(value, "Baht"));
		
	}
}
