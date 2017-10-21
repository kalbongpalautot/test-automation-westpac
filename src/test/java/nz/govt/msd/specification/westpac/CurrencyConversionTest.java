package nz.govt.msd.specification.westpac;

import nz.govt.msd.specification.ConcordionFixture;

public class CurrencyConversionTest extends ConcordionFixture {

	public String convertCurrency(String fromCurrency, String amount, String toCurrency) {
		getStoryboard()
				.addSectionContainer(String.format("Converting '%s %s' to '%s'", amount, fromCurrency, toCurrency))
				.skipFinalScreenshot();

		return workflow().openCurrencyConverter().convertCurreny(fromCurrency.trim(), amount.trim(), toCurrency.trim());
	}
}
