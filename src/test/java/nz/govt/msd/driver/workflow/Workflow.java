package nz.govt.msd.driver.workflow;

import nz.govt.msd.driver.BrowserBasedTest;
import nz.govt.msd.driver.ui.westpac.FXTravelMigrantPage;

public class Workflow {
	private final BrowserBasedTest test;

	public Workflow(BrowserBasedTest test) {
		this.test = test;
	}

	public FXTravelMigrantPage openCurrencyConverter() {
		return FXTravelMigrantPage.open(test);
	}
}
