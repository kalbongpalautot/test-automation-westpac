package com.westpac.specification.westpac;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.westpac.driver.ui.westpac.FXTravelMigrantPage;
import com.westpac.specification.ConcordionFixture;

public class TestUserStoryTwoTest extends ConcordionFixture {
	private FXTravelMigrantPage fxTravelMigrantPage;

	public String convertCurrency(String fromCurrency, String amount, String toCurrency) {
		getStoryboard()
				.addSectionContainer(String.format("Converting '%s %s' to '%s'", amount, fromCurrency, toCurrency))
				.skipFinalScreenshot();

		fxTravelMigrantPage = workflow().openCurrencyConverter().convertCurreny(fromCurrency.trim(), amount.trim(),
				toCurrency.trim());

		return checkIfMessageMatches(fromCurrency.trim(), amount.trim(), toCurrency.trim());
	}

	private String checkIfMessageMatches(String fromCurrency, String amount, String toCurrency) {
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
