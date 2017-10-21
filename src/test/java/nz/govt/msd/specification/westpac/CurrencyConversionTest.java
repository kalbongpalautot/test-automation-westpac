package nz.govt.msd.specification.westpac;

import nz.govt.msd.specification.ConcordionFixture;

public class CurrencyConversionTest extends ConcordionFixture {

	public String convertCurrency(String fromCurreny, String amount, String toCurrency) {
		return workflow().openCurrencyConverter().convertCurreny(fromCurreny.trim(), amount.toString(),
				toCurrency.trim());
	}
}
