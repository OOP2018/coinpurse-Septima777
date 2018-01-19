package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Collections;

public class MoneyUtil {

	public static void sortCoins(List<Coin> coins) {
		Collections.sort(coins);
	}

	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> sameCurrency = new ArrayList<>();
		for(Coin coin : coins){
			if(coin.getCurrency().contains(currency)){
				sameCurrency.add(coin);
			}
		}
		return sameCurrency;
	}

}
