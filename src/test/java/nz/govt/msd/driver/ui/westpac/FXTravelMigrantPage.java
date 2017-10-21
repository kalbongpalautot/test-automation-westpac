package nz.govt.msd.driver.ui.westpac;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import nz.govt.msd.AppConfig;
import nz.govt.msd.driver.BrowserBasedTest;
import nz.govt.msd.driver.ui.PageObject;
import nz.govt.msd.driver.web.ChainExpectedConditions;
import nz.govt.msd.driver.web.PageHelper;

public class FXTravelMigrantPage extends PageObject<FXTravelMigrantPage> {
	public FXTravelMigrantPage(BrowserBasedTest test) {
		//super(test, AppConfig.getInstance().getPropertyAsInteger("webdriver.defaultTimeout", "5"));
		super(test);
		// refreshPageElements();
	}
	
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

	@Override
	public ExpectedCondition<?> pageIsLoaded(Object... params) {
		return ChainExpectedConditions
				.with(ExpectedConditions.textToBePresentInElement(currentPage, TITLE))
				.and(ExpectedConditions.frameToBeAvailableAndSwitchToIt("westpac-iframe"));
	}

	public static FXTravelMigrantPage open(BrowserBasedTest test) {
		test.getBrowser().getDriver().navigate().to(AppConfig.getWestpacUrl());

		return new FXTravelMigrantPage(test);
	}

	public String convertCurreny(String fromCurrency, String money, String toCurrency) {
		//switch to the iframe
		String iframe = getCurrentFrameNameOrId();
		
		if (!PageHelper.getCurrentFrameNameOrId(getBrowser().getDriver()).equalsIgnoreCase("westpac-iframe")) {
			getBrowser().getDriver().switchTo().frame("westpac-iframe");		
		}

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
