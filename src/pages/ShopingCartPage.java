package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopingCartPage {
	WebDriver driver;

	public ShopingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getQuantityText() {

		return driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span"));
	}

	public void deleteFromCartBtn() {
		WebElement deleteBtn = driver.findElement(By.className("icon-trash"));
		deleteBtn.click();
	}

	public WebElement getEmptyShopingCartText() {
		String locator = ".alert.alert-warning";
		waitForElementToBeVisible("css", locator);
		return driver.findElement(By.cssSelector(locator));
	}

	public void waitForElementToBeVisible(String locatorType, String locatorVelue) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locatorType) {
		case "xPath":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorVelue)));
			break;

		case "css":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorVelue)));
			break;
		}
	}
}
