package patterns;

import java.text.ParseException;

import patterns.models.AmericanExpressCreditCard;
import patterns.models.CreditCard;
import patterns.models.DiscoverCreditCard;
import patterns.models.MasterCardCreditCard;
import patterns.models.VisaCreditCard;

public class CardFactory {
	
	public static CreditCard fromString(String card) throws ParseException {
		CreditCard result = null;
		
		switch (card.charAt(0)) {
			case '5':
			case '2':
				result = MasterCardCreditCard.fromString(card);
				break;
			case '3':
				result = AmericanExpressCreditCard.fromString(card);
				break;
			case '6':
				result = DiscoverCreditCard.fromString(card);
				break;
			case '4':
				result = VisaCreditCard.fromString(card);
				break;
			default:
				throw new ParseException(card,0);
		}
		
		return result;
	}
}
