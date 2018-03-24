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
	 * @param o1 is first coin (or bank note) that we have to compare.
	 * @param o2 is second coin (or bank note) that we have to compare.
	 * @return -1 if o1 come first.
	 * 			0 if o1 equals o2.
	 * 			1 if o2 come first.
	 * 
	 */
	@Override
	public int compare(Valuable o1, Valuable o2) {
		int moneyCurrency = o1.getCurrency().compareToIgnoreCase(o2.getCurrency()); 
		if(moneyCurrency == 0){
			return Double.compare(o1.getValue(), o2.getValue());
		}
		return moneyCurrency;
	}

}
