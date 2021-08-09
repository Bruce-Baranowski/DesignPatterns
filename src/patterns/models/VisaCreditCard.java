package patterns.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisaCreditCard extends CreditCard {
	private static String REGEX = "^[4]\\d{12}$";
	private static String REGEX2 = "^[4]\\d{15}$";

	public VisaCreditCard(String accountNumber, Date date, String name) {
		super(accountNumber, date, name);
	}
	
	private static boolean validate(String accnumber) {
		Pattern p = Pattern.compile(REGEX);
		Matcher m = p.matcher(accnumber);
		Pattern p2 = Pattern.compile(REGEX2);
		Matcher m2 = p2.matcher(accnumber);
		return m.matches() || m2.matches();
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
		return "Visa: " + this.getAccountNumber() + "," + this.getDate() + "," + this.getName();
	}
}
