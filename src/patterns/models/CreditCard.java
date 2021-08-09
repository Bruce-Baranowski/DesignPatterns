package patterns.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class CreditCard {
	private String accountNumber;
	private Date date;
	private String name;

	public CreditCard(String accountNumber, Date date, String name) {
		this.accountNumber = accountNumber;
		this.date = date;
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDate() {
		String pattern = "MM/YY";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	public void setDate(String date) throws ParseException {
		this.date = new SimpleDateFormat("MM/YY").parse(date);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isNotExpired() {
		Date today = new Date();
		if (today.after(date))
			return false;
		return true;
	}
	
	private static boolean validate(String accnumber) {
		return false;
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
		return accountNumber + "," + date + "," + name;
	}
	
	
}
