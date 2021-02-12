package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateBtn;

	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickUpdateBtn() throws InterruptedException {
		WebElement updateBtn = driver.findElement(By.xpath("//a[@title=\"Update\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", updateBtn);
		Thread.sleep(1000);
		updateBtn.click();
	}

	public WebElement getAddressText() {
		return driver.findElement(By.className("address_address1"));

	}

	public void clickAddNewAddress() throws InterruptedException {
		WebElement addNewAddressBtn = driver.findElement(By.xpath("//a[@title=\"Add an address\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addNewAddressBtn);
		Thread.sleep(1000);
		addNewAddressBtn.click();
	}

	public WebElement getAddress2Test() {
		return driver.findElement(By.cssSelector(".last_item > li > h3"));
	}

	public WebElement getDeleteBtn() {
		return driver.findElement(By.cssSelector("a[title='Delete']:last-child"));

	}

	public void clickDelete() {
		this.getDeleteBtn().click();
	}

	public void clickOK() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

}
