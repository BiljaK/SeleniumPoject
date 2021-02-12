package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInfoPage {
	WebDriver driver;

	public MyPersonalInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameField() {
		return driver.findElement(By.id("firstname"));
	}

	public void insertFirstName(String firstName) {
		this.getFirstNameField().sendKeys(firstName);
	}

	public WebElement getLastNameField() {
		return driver.findElement(By.id("lastname"));
	}

	public void insertLastName(String lastName) {
		this.getLastNameField().sendKeys(lastName);
	}

	public WebElement getEmailField() {
		return driver.findElement(By.id("email"));
	}

	public void insertEmail(String email) {
		this.getEmailField().sendKeys(email);
	}

	public WebElement getCorrectPasswordField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public void insertCorrectPassword(String password) {
		this.getCorrectPasswordField().sendKeys(password);
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.cssSelector(".std fieldset div > button"));
	}

	public void clickSavePIBtn() {
		this.getSaveBtn().click();
	}

	public WebElement getMyPerInfoText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p"));
	}
	public void returnOldInformation(String oldFirstName, String oldLastName, String password) throws InterruptedException {
		this.getFirstNameField().clear();
		Thread.sleep(1000);
		this.insertFirstName(oldFirstName);
		Thread.sleep(1000);
		this.getLastNameField().clear();
		Thread.sleep(1000);
		this.insertLastName(oldLastName);
		Thread.sleep(1000);
		this.insertCorrectPassword(password);
		Thread.sleep(1000);
		this.clickSavePIBtn();
	}
	
	public WebElement getMyAccountBtn() {
		return driver.findElement(By.className("account"));
	}
	
	public void clickMyAccount() {
		this.getMyAccountBtn().click();
	}
}
