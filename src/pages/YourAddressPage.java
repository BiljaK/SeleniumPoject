package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class YourAddressPage {

	WebDriver driver;

	public YourAddressPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddressField() {
		return driver.findElement(By.id("address1"));
	}

	public void insertAddress(String address) {
		this.getAddressField().sendKeys(address);
	}

	public WebElement getSaveBtn() {
		return driver.findElement(By.id("submitAddress"));
	}

	public void saveBtnClick() {
		this.getSaveBtn().click();
	}

	public WebElement getCityField() {
		return driver.findElement(By.id("city"));
	}

	public void insertCity(String city) {
		this.getCityField().sendKeys(city);
	}

	public WebElement getStateField() {
		return driver.findElement(By.id("id_state"));
	}

	public void insertState(String state) {
		Select drpState = new Select(driver.findElement(By.name("id_state")));
		drpState.selectByVisibleText(state);
	}

	public WebElement getZipCodeField() {
		return driver.findElement(By.id("postcode"));
	}

	public void insertZipCode(String zipCode) {
		this.getZipCodeField().sendKeys(zipCode);
	}

	public WebElement getMobilePhoneField() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public void insertMobilePhone(String mobilePhone) {
		this.getMobilePhoneField().sendKeys(mobilePhone);
	}

	public WebElement getAddressTitle() {
		return driver.findElement(By.id("alias"));
	}

	public void insertAddressTitle(String addressTitle) {
		this.getAddressTitle().sendKeys(addressTitle);
	}

	public WebElement getSaveAddresBtn() {
		return driver.findElement(By.id("submitAddress"));
	}

	public void clickSaveAddressBtn() {
		this.getSaveAddresBtn().click();
	}
}
