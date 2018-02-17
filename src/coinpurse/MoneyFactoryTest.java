package coinpurse;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class use for test MoneyFactory.
 * 
 * @author Noppawan Kulchol
 *
 */
public class MoneyFactoryTest {

	private MoneyFactory moneyFactory;

	/**
	 * Sets up the test fixture. Called before every test method.
	 */
	@Before
	public void setUp() {
		// nothing to initialize
	}

	/**
	 * clear old money factory and create a new one.
	 */
	@After
	public void clearMoneyFactory() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		moneyFactory = MoneyFactory.getInstance();
	}

	/** check setFactory() that it can set and get instance */
	@Test
	public void testSetAndGetInstance() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		assertEquals(MoneyFactory.getInstance().getClass().getSimpleName(), "ThaiMoneyFactory");
	}

	/** check serial number of Thai money and Malaysia money */
	@Test
	public void testBankNoteSerialNumber() {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote1 = moneyFactory.createMoney(20);
		Valuable bankNote2 = moneyFactory.createMoney(100);
		Valuable bankNote3 = moneyFactory.createMoney(500);
		assertEquals(((BankNote) bankNote1).getSerial(), 1000000);
		assertEquals(((BankNote) bankNote2).getSerial(), 1000001);
		assertEquals(((BankNote) bankNote3).getSerial(), 1000002);

		MoneyFactory.setFactory(new MalayMoneyFactory());
		moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote4 = moneyFactory.createMoney(1);
		Valuable bankNote5 = moneyFactory.createMoney(2);
		Valuable bankNote6 = moneyFactory.createMoney(5);
		assertEquals(((BankNote) bankNote4).getSerial(), 1000000000);
		assertEquals(((BankNote) bankNote5).getSerial(), 1000000001);
		assertEquals(((BankNote) bankNote6).getSerial(), 1000000002);
	}

	
	@Test
	 public void testCreateMoney(){
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		Valuable bankNote1 = moneyFactory.createMoney(20);
		Valuable bankNote2 = moneyFactory.createMoney(100); 
		assertEquals(bankNote1.getValue(), 20);
	 }
	
	
}
