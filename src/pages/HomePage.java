package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement signinTab;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSigninTab() {
		return driver.findElement(By.className("login"));
	}

	public void clickSignin() {
		getSigninTab().click();
	}	

}
