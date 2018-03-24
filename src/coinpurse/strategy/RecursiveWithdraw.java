package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.MoneyUtil;
import coinpurse.Valuable;
/**
 * withdraw money by recursion withdraw.
 * @author Noppawan Kulchol
 *
 */
public class RecursiveWithdraw implements WithdrawStrategy{

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
	 * If a solution is not found, returns other solution (Greedy).
	 * For recursion, we need to return helper method (algorithm are here)
	 */
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		MoneyUtil.filterByCurrency(money, amount.getCurrency());
		return recursiveWithdraw(amount.getValue(), money);
	}
	
	/**
	 * This method is helper method for withdraw(Valuable amount, List<Valuable> money)
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
	public List<Valuable> recursiveWithdraw(double amount, List<Valuable> money){
		/**there are 2 base case, when amount is less than zero
		 * and when amount is not equal zero but it is empty */
		if(amount < 0) return null;
		if(money.isEmpty() && amount != 0) return null;
		/** when amount equals zero, create new array list (start recursion)*/
		if (amount == 0) return new ArrayList<Valuable>();
		/** first item in the list */
		Valuable first = money.get(0);
		/** create wallet for collect amount - first value in the list then move to focus
		 * at next money in money (list)*/
		List<Valuable> wallet = recursiveWithdraw(amount - first.getValue(), money.subList(1, money.size()));
		/** Check that wallet is not equals null then add first item in the list. 
		 * Return and find value of amount minus first item in the next item */
		if (wallet != null){
			wallet.add(first);
			return wallet;
		}
		/** return amount that we want to withdraw by move to focus money that
		 * can withdraw from money(list) */
		return recursiveWithdraw(amount, money.subList(1, money.size()));
	}	

}
