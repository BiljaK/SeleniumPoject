package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SigninPage {

	WebDriver driver;
	WebElement signInBtn;
	WebElement emailInputField;
	WebElement passwordInputField;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailInputField() {
		return driver.findElement(By.id("email"));
	}

	public void navigateToEmailInput(String email) {
		this.getEmailInputField().sendKeys(email);
	}

	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public void navigateToPasswordInput(String password) {
		this.getPasswordInputField().sendKeys(password);
	}

	public WebElement getSignInBtn() {
		return driver.findElement(By.id("SubmitLogin"));
	}

	public void navigateToSiginBtn() {
		this.getSignInBtn().click();
	}

	public WebElement getErrorText() {
		return driver.findElement(By.cssSelector(".alert.alert-danger > ol > li"));
	}

	public String getAuthenticationText() {
		return driver.findElement(By.className("page-heading")).getText();
	}

}
