package nz.govt.msd.specification.westpac;

import nz.govt.msd.driver.ui.westpac.FXTravelMigrantPage;
import nz.govt.msd.specification.ConcordionFixture;

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
