package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

/**
 * This class there are 2 method sortMoney and filterByCurrency.
 * find the money that are same currency.
 * 
 * @author Noppawan Kulchol
 *
 */
public class MoneyUtil {

	/**
	 * Sort money in the list.
	 * 
	 * @param money
	 *            are coins and bank note in the list.
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		Collections.sort(money, new ValueComparator());
	}

	/**
	 * Find the money that are same currency and get them to the new list.
	 * 
	 * @param money
	 *            are money in the list.
	 * @param currency
	 *            is currency of money.
	 * @return the list of the coins with same currency.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<? extends E> money, String currency) {
		List<E> sameCurrency = new ArrayList<E>();
		for (E valuable : money) {
			if (valuable.getCurrency().equals(currency)) {
				sameCurrency.add(valuable);
			}
		}
		return sameCurrency;
	}

	/**
	 * Print value and currency of money
	 * 
	 * @param money
	 *            are money in the list.
	 */
	public static void printValue(List<? extends Valuable> money) {
		for (Valuable value : money) {
			System.out.println(value.getValue() + "-" + value.getCurrency());
		}
	}

	/**
	 * Return the largest argument by sort order. using compareTo() for comparing.
	 * @param args one or more Comparable objects to compare.
	 * @return the largest argument.
	 * @throws IllegalArgumentException if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) throws IllegalArgumentException{

		E maxNumber = args[0];
		for (int i = 0; i < args.length; i++) {
			if (args[i].compareTo(maxNumber) > 0) {
				maxNumber = args[i];
			}
		}
		return maxNumber;
	}

	
}
