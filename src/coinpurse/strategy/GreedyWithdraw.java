package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;
/**
 * withdraw money by greedy withdraw.
 * @author Noppawan Kulchol
 *
 */
public class GreedyWithdraw implements WithdrawStrategy{
	
	/**
	 * Withdraw money that we want but it must less than money thaw we had.
	 * 
	 * @param amount is money that we want to withdraw which it must less than
	 * money that we had.
	 * 
	 * @param money is list that collect money that we had at this moment.
	 * Must not be null, but may be an empty list. 
	 * 
	 * @return if a solution is found, return a List containing references
	 * from the money parameter (List) whose sum equals the amount.
	 * If a solution is not found, returns other solution (Recursion).
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		
		double monty = amount.getValue();
		String currency = amount.getCurrency();
		
		if (monty < 0) return null;
		List<Valuable> templist = new ArrayList<Valuable>();
		Comparator<Valuable> comp = new ValueComparator();
		Collections.sort(money, comp);
		Collections.reverse(money); 
		for (int i = 0; i < money.size(); i++) {
			Valuable m = money.get(i);
			if (monty >= m.getValue() && currency.equalsIgnoreCase(m.getCurrency())) {
				monty = monty - m.getValue();
				templist.add(m);
			}			
		}		
		if (monty != 0)	return null;		
		return templist;
	}

}
