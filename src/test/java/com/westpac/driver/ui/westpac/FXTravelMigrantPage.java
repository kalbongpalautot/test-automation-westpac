package com.westpac.driver.ui.westpac;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.westpac.AppConfig;
import com.westpac.driver.ui.PageObject;

import nz.govt.msd.driver.BrowserBasedTest;
import nz.govt.msd.driver.web.ChainExpectedConditions;
import nz.govt.msd.driver.web.PageHelper;

public class FXTravelMigrantPage extends PageObject<FXTravelMigrantPage> {

	private static final String TITLE = "Currency converter";

	@FindBy(css = "#main")
	WebElement currentPage;

	@FindBy(id = "ConvertFrom")
	WebElement convertFrom;

	@FindBy(id = "Amount")
	WebElement amount;

	@FindBy(id = "ConvertTo")
	WebElement convertTo;

	@FindBy(id = "convert")
	WebElement convert;

	@FindBy(css = "#resultsdiv > em")
	WebElement message;

	@FindBy(css = "#errordiv")
	WebElement errorMessage;

	public FXTravelMigrantPage(BrowserBasedTest test) {
		// super(test,
		// AppConfig.getInstance().getPropertyAsInteger("webdriver.defaultTimeout",
		// "5"));
		super(test);
	}

	@Override
	public ExpectedCondition<?> pageIsLoaded(Object... params) {
		return ChainExpectedConditions.with(ExpectedConditions.textToBePresentInElement(currentPage, TITLE))
				.and(ExpectedConditions.frameToBeAvailableAndSwitchToIt("westpac-iframe"));
	}

	public static FXTravelMigrantPage open(BrowserBasedTest test) {
		test.getBrowser().getDriver().navigate().to(AppConfig.getWestpacUrl());

		return new FXTravelMigrantPage(test);
	}

	public FXTravelMigrantPage convertCurreny(String fromCurrency, String money, String toCurrency) {
		String iframe = "westpac-iframe";

		// switch to the iframe
		if (!PageHelper.getCurrentFrameNameOrId(getBrowser().getDriver()).equalsIgnoreCase(iframe)) {
			getBrowser().getDriver().switchTo().frame(iframe);
		}

		convertFrom.sendKeys(fromCurrency);
		amount.sendKeys(money);
		convertTo.sendKeys(toCurrency);

		return capturePageAndSubmit(convert, FXTravelMigrantPage.class);
	}

	public String getMessage() {
		capturePage(message, "Currency Converter");
		return message.getText();
	}

	public String getErrorMessage() {
		capturePage(errorMessage);
		return errorMessage.getText();
	}

}
