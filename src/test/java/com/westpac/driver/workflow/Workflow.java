package com.westpac.driver.workflow;

import com.westpac.driver.ui.westpac.FXTravelMigrantPage;

import nz.govt.msd.driver.BrowserBasedTest;

public class Workflow {
	private final BrowserBasedTest test;

	public Workflow(BrowserBasedTest test) {
		this.test = test;
	}

	public FXTravelMigrantPage openCurrencyConverter() {
		return FXTravelMigrantPage.open(test);
	}
}
