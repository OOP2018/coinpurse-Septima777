package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;
import coinpurse.strategy.WithdrawStrategy;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Noppawan Kulchol
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Valuable> money = new ArrayList<Valuable>();
	Comparator<Valuable> comp = new ValueComparator();
	private WithdrawStrategy strategy;
	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		setWithdrawStrategy(new GreedyWithdraw());
//		setWithdrawStrategy(new RecursiveWithdraw());
		
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}
	
	/**
	 * This method help us to choose the way to withdraw money.
	 * There are 2 ways, Greed and Recursion
	 * @param strategy is the way to withdraw either greedy or recursion.
	 */
	public void setWithdrawStrategy(WithdrawStrategy strategy){
		this.strategy = strategy;
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double total = 0.0;
		for (Valuable valua : money) {
			total = total + valua.getValue();
		}
		return total;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() >= capacity;
	}

	/**
	 * Insert a coin and bank note into the purse. The coin and bank note is
	 * only inserted if the purse has space for it and the coin and bank note
	 * have positive value. No worthless coins and bank notes!
	 * 
	 * @param value
	 *            is a Coin and bank note object to insert into purse
	 * @return true if coin or bank note inserted, false if can't insert
	 */
	public boolean insert(Valuable value) {
		// if the purse is already full then can't insert anything.
		if (value.getValue() <= 0)
			return false;
		if (!isFull()) {
			money.add(value);
			Collections.sort(money,new ValueComparator());
			return true;
		}
		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Money
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		return withdraw(new Money(amount, "Baht"));
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Money
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested but it return just the same currency.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Money objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(Valuable amount) {

		List<Valuable> list = strategy.withdraw(amount, money);
		
		if(list == null) return null;
		for (Valuable withDrawnValue : list) {
			money.remove(withDrawnValue);
		}
		
		Valuable[] array = new Valuable[list.size()];
		return list.toArray(array);
		
}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 * 
	 * @return description of the purse contents.
	 */
	public String toString() {
		return count() + " money with value " + getBalance();
	}

	
}
