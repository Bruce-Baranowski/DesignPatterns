package patterns.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiscoverCreditCard extends CreditCard {
	private static String REGEX = "^[6]\\d{15}$";

	public DiscoverCreditCard(String accountNumber, Date date, String name) {
		super(accountNumber, date, name);
	}
	
	private static boolean validate(String accnumber) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(accnumber);
		return m.matches();
	}
	
	public static CreditCard fromString(String str) throws ParseException {
		String[] cardInfo = str.split(",");
		
		if (validate(cardInfo[0]) == false) {
			throw new ParseException(str, 0);
		}
		
		Date expiry = new SimpleDateFormat("MM/YY").parse(cardInfo[1]);
		
		return new MasterCardCreditCard(cardInfo[0],expiry,cardInfo[2]);
	}
	@Override
	public String toString() {
		return "Discover: " + this.getAccountNumber() + "," + this.getDate() + "," + this.getName();
	}
}
