package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);

	}
	
	@Test (priority = 0)
	public void logIn() throws InterruptedException {
		String email = citacIzExcela.getStringData("TS Login", 9, 3);
		String password = citacIzExcela.getStringData("TS Login", 10, 3);
		String expectedText = citacIzExcela.getStringData("TS Login", 11, 4);
		String actualText;
		
		homePage.clickSignin();
		Thread.sleep(1000);
		signinPage.navigateToEmailInput(email);
		Thread.sleep(1000);
		signinPage.navigateToPasswordInput(password);
		Thread.sleep(1000);
		signinPage.navigateToSiginBtn();
		
		actualText = myAccountPage.getLogOutTab().getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test (priority = 5)
	public void logInWithInvalidEmail() throws InterruptedException {
		String email = citacIzExcela.getStringData("TS Login", 18, 3);
		String password = citacIzExcela.getStringData("TS Login", 19, 3);
		String expectedText = citacIzExcela.getStringData("TS Login", 20, 4);
		String actualText;
		
		homePage.clickSignin();
		Thread.sleep(1000);
		signinPage.navigateToEmailInput(email);
		Thread.sleep(1000);
		signinPage.navigateToPasswordInput(password);
		Thread.sleep(1000);
		signinPage.navigateToSiginBtn();
		
		actualText = signinPage.getErrorText().getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test (priority = 10)
	public void logInWithInvalidPassword() throws InterruptedException {
		String email = citacIzExcela.getStringData("TS Login", 27, 3);
		int password = citacIzExcela.getIntData("TS Login", 28, 3);
		String expectedText = citacIzExcela.getStringData("TS Login", 29, 4);
		String actualText;
		
		homePage.clickSignin();
		Thread.sleep(1000);
		signinPage.navigateToEmailInput(email);
		Thread.sleep(1000);
		signinPage.navigateToPasswordInput(String.valueOf(password));
		Thread.sleep(1000);
		signinPage.navigateToSiginBtn();
		
		actualText = signinPage.getErrorText().getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	@Test (priority = 15)
	public void logInWithoutCredetials() throws InterruptedException {
		String email = citacIzExcela.getStringData("TS Login", 36, 3);
		String password = citacIzExcela.getStringData("TS Login", 37, 3);
		String expectedText = citacIzExcela.getStringData("TS Login", 38, 4);
		String actualText;
		
		homePage.clickSignin();
		Thread.sleep(1000);
		signinPage.getEmailInputField().clear();
		signinPage.navigateToEmailInput(email);
		Thread.sleep(1000);
		signinPage.getPasswordInputField().clear();
		signinPage.navigateToPasswordInput(password);
		Thread.sleep(1000);
		signinPage.navigateToSiginBtn();
		
		actualText = signinPage.getErrorText().getText();
		Assert.assertEquals(actualText, expectedText);
	}


	@Test (priority = 20)
	public void logOut() throws InterruptedException {
		logIn();
		Thread.sleep(1000);
		myAccountPage.clickLogOutBtn();
		
		String logoutText = signinPage.getAuthenticationText();
		Assert.assertEquals(logoutText, citacIzExcela.getStringData("TS Login", 44, 4));
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
