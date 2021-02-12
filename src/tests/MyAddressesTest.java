package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressesTest extends BaseTest {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);

		String email = citacIzExcela.getStringData("TS Login", 9, 3);
		String password = citacIzExcela.getStringData("TS Login", 10, 3);

		validLogIn(email, password);
	}

	// @Test (priority = 0)
	public void updateAddress() throws InterruptedException {

		String address = citacIzExcela.getStringData("TS My address", 11, 3);
		String expectedText = citacIzExcela.getStringData("TS My address", 11, 3);
		String actualText;

		myAccountPage.clickOnMyAddressBtn();
		Thread.sleep(1000);
		myAddressPage.clickUpdateBtn();
		Thread.sleep(1000);
		yourAddressPage.getAddressField().clear();
		Thread.sleep(1000);
		yourAddressPage.insertAddress(address);
		Thread.sleep(1000);
		yourAddressPage.saveBtnClick();

		actualText = myAddressPage.getAddressText().getText();
		Assert.assertEquals(actualText, expectedText);

	}

	// @Test (priority = 5)
	public void add2Address() throws InterruptedException {
		String address = citacIzExcela.getStringData("TS My address", 22, 3);
		String city = citacIzExcela.getStringData("TS My address", 23, 3);
		String state = citacIzExcela.getStringData("TS My address", 24, 3);
		int zipCode = citacIzExcela.getIntData("TS My address", 25, 3);
		int mobilePhone = citacIzExcela.getIntData("TS My address", 26, 3);
		String addressTitle = citacIzExcela.getStringData("TS My address", 27, 3);
		String expectedText = citacIzExcela.getStringData("TS My address", 28, 4);
		String actualText;

		Thread.sleep(1000);
		myAccountPage.clickOnMyAddressBtn();
		Thread.sleep(1000);
		myAddressPage.clickAddNewAddress();
		yourAddressPage.getAddressField().clear();
		Thread.sleep(1000);
		yourAddressPage.insertAddress(address);
		Thread.sleep(1000);
		yourAddressPage.getCityField().clear();
		yourAddressPage.insertCity(city);
		yourAddressPage.insertState(state);
		yourAddressPage.insertZipCode(String.valueOf(zipCode));
		yourAddressPage.insertMobilePhone(String.valueOf(mobilePhone));
		yourAddressPage.insertAddressTitle(addressTitle);
		yourAddressPage.clickSaveAddressBtn();

		actualText = myAddressPage.getAddress2Test().getText();
		Assert.assertEquals(actualText, expectedText);

	}

	@Test(priority = 10)
	public void removeAddress() throws InterruptedException {
		add2Address();
		String expectedText = citacIzExcela.getStringData("TS My address", 37, 3);
		String actualText;

		Thread.sleep(1000);
		myAddressPage.clickDelete();
		Thread.sleep(1000);
		myAddressPage.clickOK();

		actualText = myAddressPage.getAddress2Test().getText();
		Assert.assertFalse(actualText.equals(expectedText));
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
