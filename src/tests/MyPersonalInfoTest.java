package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoTest extends BaseTest {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		
		String email = citacIzExcela.getStringData("TS Login", 9, 3);
		String password = citacIzExcela.getStringData("TS Login", 10, 3);
		
		validLogIn(email,password);
	}
	
	@Test (priority = 0)
	public void editMyPersonalInformations() throws InterruptedException {
		
		String firstName = citacIzExcela.getStringData("TS Personal Informations", 8, 3);
		String lastName = citacIzExcela.getStringData("TS Personal Informations", 9, 3);
		String email = citacIzExcela.getStringData("TS Personal Informations", 10, 3);
		String correctPassword = citacIzExcela.getStringData("TS Personal Informations", 11, 3);
		String expectedText = citacIzExcela.getStringData("TS Personal Informations", 12, 4);
		String actualText;
		
		String oldFirstName;
		String oldLastName;
		
		Thread.sleep(1000);
		myAccountPage.clickMyPersonalBtn();
		Thread.sleep(1000);
		oldFirstName = myPesonalInfoPage.getFirstNameField().getAttribute("value");
		myPesonalInfoPage.getFirstNameField().clear();
		Thread.sleep(1000);
		myPesonalInfoPage.insertFirstName(firstName);
		Thread.sleep(1000);
		oldLastName = myPesonalInfoPage.getLastNameField().getAttribute("value");
		myPesonalInfoPage.getLastNameField().clear();
		Thread.sleep(1000);
		myPesonalInfoPage.insertLastName(lastName);
		Thread.sleep(1000);
		myPesonalInfoPage.getEmailField().clear();
		Thread.sleep(1000);
		myPesonalInfoPage.insertEmail(email);
		Thread.sleep(1000);
		myPesonalInfoPage.getCorrectPasswordField().clear();
		Thread.sleep(1000);
		myPesonalInfoPage.insertCorrectPassword(correctPassword);
		Thread.sleep(1000);
		myPesonalInfoPage.clickSavePIBtn();
		
		actualText = myPesonalInfoPage.getMyPerInfoText().getText();
		Assert.assertEquals(actualText, expectedText);
		
		myPesonalInfoPage.clickMyAccount();
		Thread.sleep(1000);
		myAccountPage.clickMyPersonalBtn();
		Thread.sleep(1000);
		myPesonalInfoPage.returnOldInformation(oldFirstName, oldLastName, correctPassword);
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
