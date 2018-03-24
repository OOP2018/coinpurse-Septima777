package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;
/**
 * This interface give you algorithm to decide how to withdraw money.
 * There is more than one possible algorithm for choosing what to withdraw,
 * and we might want to change the algorithm. So, we define a WithdrawStrategy
 * for Purse that easy to find the way to withdraw, and write a concrete 
 * implementation for each algorithm.
 * @author Noppawan Kulchol
 *
 */
public interface WithdrawStrategy {
	
	/**
	 * Withdraw money that we want but it must less than money that we had.
	 * 
	 * @param amount is money that we want to withdraw which it must less than
	 * money that we had.
	 * 
	 * @param money is list that collect money that we had at this moment.
	 * Must not be null, but may be an empty list. 
	 * 
	 * @return if a solution is found, return a List containing references
	 * from the money parameter (List) whose sum equals the amount.
	 * If a Greedy is not found, return Recursion solution but
	 * If a Recursion is not found, return Greedy solution. 
	 */
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money);
}
