package nz.govt.msd.driver.ui.westpac;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import nz.govt.msd.AppConfig;
import nz.govt.msd.driver.BrowserBasedTest;
import nz.govt.msd.driver.ui.PageObject;

public class FXTravelMigrantPage extends PageObject<FXTravelMigrantPage> {
	public FXTravelMigrantPage(BrowserBasedTest test) {
		//super(test, AppConfig.getInstance().getPropertyAsInteger("webdriver.defaultTimeout", "5"));
		super(test);
		// refreshPageElements();
	}

	@FindBy(id = "ConvertFrom")
	WebElement convertFrom;

	@FindBy(id = "Amount")
	WebElement amount;

	@FindBy(id = "ConvertTo")
	WebElement convertTo;

	@FindBy(id = "convert")
	WebElement convert;

	@Override
	public ExpectedCondition<?> pageIsLoaded(Object... params) {
		return ExpectedConditions.visibilityOf(convert);
	}

	public static FXTravelMigrantPage open(BrowserBasedTest test) {
		test.getBrowser().getDriver().navigate().to(AppConfig.getWestpacUrl());

		return new FXTravelMigrantPage(test);
	}

	public String convertCurreny(String fromCurrency, String money, String toCurrency) {
		// String fromCurrency = "New Zealand Dollar";
		// String money = "100";
		// String toCurrency = "United States Dollar";

		convertFrom.sendKeys(fromCurrency);
		amount.sendKeys(money);
		convertTo.sendKeys(toCurrency);
		capturePageAndClick(convert, FXTravelMigrantPage.class);

		return null;
	}

	// @Override
	// public void refreshPageElements() {
	// // PageFactory.initElements(
	// // new PageObjectAwareHtmlElementDecorator(new
	// // HtmlElementLocatorFactory(getBrowser().getDriver()), this),
	// // this);
	//
	// PageFactory.initElements(new HtmlElementDecorator(new
	// HtmlElementLocatorFactory(getBrowser().getDriver())),
	// this);
	//
	// // PageFactory.initElements(new
	// CustomElementDecorator(getBrowser().getDriver(),
	// // getTest()), this);
	//
	// // System.out.println("Not implemented..");
	// }

}
