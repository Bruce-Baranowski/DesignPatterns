package patterns;

import java.text.ParseException;

import patterns.models.CreditCard;

public class DesignPatterns {

	public static void main(String[] args) {
		try {
			CreditCard test = CardFactory.fromString("5100123412341234,07/22,John Doe");
			System.out.print(test);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
