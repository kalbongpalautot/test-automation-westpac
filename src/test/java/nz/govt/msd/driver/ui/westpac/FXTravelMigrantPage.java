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

	public String convertCurreny(String fromCurrency, String money, String toCurrency) {
		// switch to the iframe
		String iframe = "westpac-iframe";

		if (!PageHelper.getCurrentFrameNameOrId(getBrowser().getDriver()).equalsIgnoreCase(iframe)) {
			getBrowser().getDriver().switchTo().frame(iframe);
		}

		convertFrom.sendKeys(fromCurrency);
		amount.sendKeys(money);
		convertTo.sendKeys(toCurrency);

		capturePageAndSubmit(convert, FXTravelMigrantPage.class);
		convert.click();

		capturePage("Currency Converter");

		if (message.getText().contains("100 New Zealand Dollar")) {
			return "displayed correctly";
		}

		return message.getText();

	}

}
