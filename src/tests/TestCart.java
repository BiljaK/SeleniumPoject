package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(4000);

		String email = citacIzExcela.getStringData("TS Login", 9, 3);
		String password = citacIzExcela.getStringData("TS Login", 10, 3);

		validLogIn(email, password);
	}

	@Test(priority = 0)
	public void add1ProductInCart() throws InterruptedException {

		String expectedText = citacIzExcela.getStringData("TS Product cart", 9, 4);
		String actualText;

		Thread.sleep(1000);
		myAccountPage.clickDressesTab();
		Thread.sleep(1000);
		dressesPage.clickAdd1Dress();
		Thread.sleep(6000);
		dressesPage.proceedToCheckOut();
		Thread.sleep(1000);

		actualText = shopingCartPage.getQuantityText().getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 5)
	public void add1ProductInCartQuantity3() throws InterruptedException {

		int quantity = citacIzExcela.getIntData("TS Product cart", 19, 3);
		String expectedText = citacIzExcela.getStringData("TS Product cart", 19, 4);
		String actualText;

		Thread.sleep(3000);
		myAccountPage.clickDressesTab();
		Thread.sleep(3000);
		dressesPage.addProductAndGoCart();
		Thread.sleep(3000);
		dressesPage.addQuantity(String.valueOf(quantity));
		Thread.sleep(8000);

		actualText = shopingCartPage.getQuantityText().getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 10)
	public void add3ProductsInCart() throws InterruptedException {
		String expectedText = citacIzExcela.getStringData("TS Product cart", 32, 4);
		String actualText;

		Thread.sleep(3000);
		myAccountPage.clickDressesTab();
		Thread.sleep(8000);
		dressesPage.clickAdd1Dress();
		Thread.sleep(8000);
		dressesPage.continueShopingBtn();
		Thread.sleep(8000);
		dressesPage.clickAdd2ndDress();
		Thread.sleep(8000);
		dressesPage.continueShopingBtn();
		Thread.sleep(8000);
		dressesPage.clickAdd3rdDress();
		Thread.sleep(8000);
		dressesPage.proceedToCheckOut();
		Thread.sleep(6000);

		actualText = shopingCartPage.getQuantityText().getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@Test(priority = 15)
	public void removeProductsFromCart() throws InterruptedException {
		String expectedText = citacIzExcela.getStringData("TS Product cart", 42, 4);
		String actualText;

		add3ProductsInCart();
		Thread.sleep(3000);
		shopingCartPage.deleteFromCartBtn();
		Thread.sleep(6000);
		shopingCartPage.deleteFromCartBtn();
		Thread.sleep(8000);
		shopingCartPage.deleteFromCartBtn();

		actualText = shopingCartPage.getEmptyShopingCartText().getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}
}
