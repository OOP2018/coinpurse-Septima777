package coinpurse;

import java.util.ResourceBundle;

public class ReadFile {
	public static MoneyFactory read(){
		ResourceBundle bundle = ResourceBundle.getBundle("purse");
		String factoryclass = bundle.getString("moneyfactory");
		MoneyFactory factory = null;
		try {
			factory = (MoneyFactory)Class.forName(factoryclass).newInstance();
		} catch (ClassCastException e) {
			System.out.println(factory+" is not type MoneyFactory");
		} catch (Exception e) {
			System.out.println("Error creating MoneyFactory "+e.getMessage());
		}
		if (factory == null) System.exit(1);
		return factory;
	}

}
