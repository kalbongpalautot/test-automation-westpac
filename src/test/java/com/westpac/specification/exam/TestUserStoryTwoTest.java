package com.westpac.specification.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.westpac.driver.ui.westpac.FXTravelMigrantPage;
import com.westpac.specification.ConcordionFixture;

public class TestUserStoryTwoTest extends ConcordionFixture {
	private FXTravelMigrantPage fxTravelMigrantPage;

	public String convertCurrency(String fromCurrency, String amount, String toCurrency) {
		fromCurrency = fromCurrency.trim();
		amount = amount.trim();
		toCurrency = toCurrency.trim();
		
		getStoryboard()
				.addSectionContainer(String.format("Converting '%s %s' to '%s'", amount, fromCurrency, toCurrency))
				.skipFinalScreenshot();

		fxTravelMigrantPage = workflow().openCurrencyConverter().convertCurreny(fromCurrency, amount,
				toCurrency);

		return checkIfMessageMatches(fromCurrency.trim(), amount.trim(), toCurrency.trim());
	}

	private String checkIfMessageMatches(String fromCurrency, String amount, String toCurrency) {
		//This is not an exact comparison of the message but rather a regular expression only
		//This will not consider the exact or correct exchange rates as it is not known but will verify the behaviour
		String token = fromCurrency.equals("New Zealand Dollar")
				? amount + " " + fromCurrency + " @ .* = .* " + toCurrency
				: amount + " " + fromCurrency + " .*";

		String message = fxTravelMigrantPage.getMessage();

		Pattern p = Pattern.compile(token);
		Matcher m = p.matcher(message);

		if (m.find()) {
			return "Passed";
		}

		return message;
	}
}
