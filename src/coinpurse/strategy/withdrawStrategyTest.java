package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.Coin;
import coinpurse.MoneyFactory;
import coinpurse.Valuable;
/**
 * This class use for test withdraw working. It can test both Greedy and Recusion.
 * @author Noppawan Kulchol
 *
 */
public class withdrawStrategyTest {

	/** tolerance for comparing two double values */
	private static final double TOL = 1.0E-6;
	/** strategy to withdraw */
	private WithdrawStrategy strategy;
	/** Thai currency */
	private final String THAI_CURRENCY = "Baht";
	/** Malaysia currency */
	private final String MALAY_CURRENCY = "Ringgit";
	/** list that collect money */
	private List<Valuable> money1 = new ArrayList<>();
	/** list that collect money */
	private List<Valuable> money2 = new ArrayList<>();
	/** Money factory that can create money */
	private MoneyFactory moneyFactory = MoneyFactory.getInstance();
	
	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() throws Exception {
		/** clear money all the time before test others. */
		money1.clear();
		money2.clear();
		/** withdraw by Greedy */
//		strategy = new GreedyWithdraw();
		/** withdraw by Recursion */
		strategy = new RecursiveWithdraw();
	}

	/**
	 * Test simple withdraw coin and bank note. If there are money in the list
	 * it can withdraw money.
	 */
	@Test
	public void testSimpleWithdraw() {
		Valuable coin = moneyFactory.createMoney(1);
		money1.add(coin);
		money2.add(coin);
		assertEquals(strategy.withdraw(coin,money1),money2);
		money1.clear();
		money2.clear();
		Valuable bankNote = moneyFactory.createMoney(20);
		money1.add(bankNote);
		money2.add(bankNote);
		assertEquals(strategy.withdraw(bankNote,money1),money2);
		
		
	}
	
	/**
	 * Test that cannot withdraw money if there is not money (empty or zero).
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testZeroWithdraw() {
		Valuable value = moneyFactory.createMoney(0);
		money1.add(value);
		assertNull(strategy.withdraw(value, money1));
		
	}
	
	/**
	 * Test that cannot withdraw money if balance is less than money 
	 * that you want to withdraw.
	 */
	@Test
	public void testImpossibleWithdraw(){
		Valuable coin = moneyFactory.createMoney(10);
		money1.add(coin);
		Valuable bankNote = moneyFactory.createMoney(20);
		assertNull(strategy.withdraw(bankNote, money1));
	}
	
	/**
	 * Test that you cannot withdraw money that less than zero.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testNegativeWithdraw(){
		Valuable value = moneyFactory.createMoney(Double.NEGATIVE_INFINITY);
		Valuable value2 = moneyFactory.createMoney(-1);
		money1.add(value);
		money1.add(value2);
		assertNull(strategy.withdraw(value, money1));
		assertNull(strategy.withdraw(value2, money1));
	}
	
	/**
	 * Test that you cannot withdraw money which are not the same currency.
	 */
	@Test
	public void testCurrencyMoney(){
		Valuable thaiMoney = new Coin(5, THAI_CURRENCY);
		Valuable malayMoney = new Coin(5, MALAY_CURRENCY);
		money1.add(thaiMoney);
		money2.add(malayMoney);
		assertNotEquals(strategy.withdraw(new Coin(10, MALAY_CURRENCY), money1), money2);
		
		
	}
	
	/**
	 * Test that you cannot withdraw if you did not add money (empty).
	 */
	@Test
	public void testEmptyWithdraw(){
		Valuable banknote = moneyFactory.createMoney(100);
		assertNull(strategy.withdraw(banknote, money1));
		
		Valuable coin = moneyFactory.createMoney(10);
		assertNull(strategy.withdraw(coin, money1));
	}

}
