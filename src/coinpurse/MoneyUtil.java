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
			if (coin.getCurrency().contains(currency)) {
				sameCurrency.add(coin);
			}
		}
		return sameCurrency;
	}

}
