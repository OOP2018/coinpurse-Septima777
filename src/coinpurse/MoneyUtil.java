package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.transformation.SortedList;

import java.util.Collections;

/**
 * This class there are 2 method sortMoney and filterByCurrency.
 * 
 * @author Noppawan Kulchol
 *
 */
public class MoneyUtil {

	/**
	 * Sort value of each elements (money) in the list.
	 * 
	 * @param money
	 *            are coins and bank notes in the list which we want to sort.
	 */
	public static void sortMoney(List<? extends Valuable> money) {
		Collections.sort(money, new ValueComparator());
	}

	/**
	 * Return a List of the elements from the parameter List
	 * (money) with currency that is the same as the
	 * currency parameter.
	 * 
	 * @param money
	 *            are money in the list.
	 * @param currency
	 *            is currency of money that we want to get them in the new list.
	 * @return the list of the money with same currency.
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
	 * Print value and currency of each elements in the list (money)
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

		E maxValue = args[0];
		for (int i = 0; i < args.length; i++) {
			if (args[i].compareTo(maxValue) > 0) {
				maxValue = args[i];
			}
		}
		return maxValue;
	}
	
	public static void main(String[] args) {
		List<BankNote> list = new ArrayList<BankNote>();
		list.add( new BankNote(10.0, "USD", 1) );
		list.add( new BankNote(500.0, "Bath", 2) );
		list.add(new BankNote(350.0, "USD", 3));
		list.add( new BankNote(200.0, "Bath", 4) );
		System.out.println("list :");
		System.out.println(list);
		System.out.println("================");
		
		MoneyUtil.sortMoney( list );
		System.out.println("Test sortMoney :");
		System.out.println(list);
		System.out.println("================");
		
		List<Coin> coins = Arrays.asList( new Coin(5,"Baht"),
		new Coin(0.1,"Ringgit"), new Coin(5,"Cent"), new Coin(10,"Baht"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht"); 
		System.out.println("Test filterByCurrentcy :");
		System.out.println(result);
		System.out.println("================");
		
		Money m1 = new BankNote(300, "Baht", 1);
		Money m2 = new BankNote(5000, "Baht", 2);
		Money m3 = new Coin(20, "Baht");
		Money max = MoneyUtil.max( m1, m2, m3 );
		System.out.println("Test max :");
		System.out.println("m1 = " + m1.value);
		System.out.println("m2 = " + m2.value);
		System.out.println("m3 = " + m3.value);
		System.out.println("max = " + max);
		
	}

	
}
