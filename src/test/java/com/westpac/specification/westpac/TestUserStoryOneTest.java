package com.westpac.specification.westpac;

import com.westpac.driver.ui.westpac.FXTravelMigrantPage;
import com.westpac.specification.ConcordionFixture;

public class TestUserStoryOneTest extends ConcordionFixture {
	private FXTravelMigrantPage fxTravelMigrantPage;

	public void convertCurrencyWithNoAmount() {

		fxTravelMigrantPage = workflow().openCurrencyConverter();
		fxTravelMigrantPage.convertCurreny("New Zealand Dollar", "", "United States Dollar");
	}

	public String getErrorMessage() {
		return fxTravelMigrantPage.getErrorMessage();
	}
}
