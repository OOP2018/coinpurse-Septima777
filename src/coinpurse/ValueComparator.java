package coinpurse;

import java.util.Comparator;

/**
 * This class implements Comparator for compare value and currency of money.
 * @author Noppawan Kulchol
 *
 */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two objects that implement Valuable. First compare them by
	 * currency, so that "Baht" < "Dollar". If both objects have the same
	 * currency, order them by value.
	 * 
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		return o1.getCurrency().compareToIgnoreCase(o2.getCurrency());
	}

}
