package coinpurse;


public abstract class MoneyFactory {

	private static MoneyFactory instance;
	protected long nextSerialNumber = 1000000;
	
	public static MoneyFactory getInstance(){
		if(instance == null){
			instance = ReadFile.read();
		}
		return instance;		
	}
	
	public abstract Valuable createMoney(double value);

	public Valuable createMoney(String value){
		double dValue = 0;
		try {
			dValue = Double.parseDouble(value);
		} catch (IllegalArgumentException e) {
			System.out.println("Not valid");
		}
		return createMoney(dValue);
	}
	
	public static void setFactory(MoneyFactory f){
		MoneyFactory.instance = f;
	}
	
	public static void main(String[] args) {
		MoneyFactory factory = MoneyFactory.getInstance();
		Valuable m = factory.createMoney(5);
		System.out.println(m.toString());
		Valuable m2 = factory.createMoney(0.05);
		System.out.println(m2.getCurrency());
		System.out.println(m2.toString());
		Valuable m3 = factory.createMoney(50);
		System.out.println(m3.toString());
		Valuable m5 = factory.createMoney(3000);
		System.out.println(m5.toString());
		Valuable m4 = factory.createMoney(1000);
		System.out.println(m4.toString());
	}

}
