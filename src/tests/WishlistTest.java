package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishlistTest extends BaseTest {
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);

		String email = citacIzExcela.getStringData("TS Login", 9, 3);
		String password = citacIzExcela.getStringData("TS Login", 10, 3);

		validLogIn(email, password);
	}

	@Test (priority = 0)
	public void addWishlist() throws InterruptedException {
		String wlName = citacIzExcela.getStringData("TS My wish list", 8, 3);
		String expectedText = citacIzExcela.getStringData("TS My wish list", 9, 4);
		String actualText;

		Thread.sleep(1000);
		myAccountPage.clickOnMyWishlistBtn();
		myWishlistPage.addNewWishlistName(wlName);
		myWishlistPage.clickSaveBtn();
		Thread.sleep(2000);

		actualText = myWishlistPage.getWishlistSpecificText(1).getText();
		Assert.assertEquals(actualText, expectedText);

	}

//	@Test (priority = 5)
	public void add2Wishlist() throws InterruptedException {
		String wlName2 = citacIzExcela.getStringData("TS My wish list", 17, 3);
		String wlName3 = citacIzExcela.getStringData("TS My wish list", 21, 3);
		String expectedText = citacIzExcela.getStringData("TS My wish list", 19, 4);
		String actualText;
		String expectedText2 = citacIzExcela.getStringData("TS My wish list", 23, 4);
		String actualText2;

		myAccountPage.clickOnMyWishlistBtn();
		myWishlistPage.add2WishlistName(wlName2);
		myWishlistPage.clickSaveBtn();
		myWishlistPage.add3WishlistName(wlName3);
		myWishlistPage.clickSaveBtn();
		Thread.sleep(2000);

		actualText = myWishlistPage.getWishlistSpecificText(2).getText();
		Assert.assertEquals(actualText, expectedText);
		actualText2 = myWishlistPage.getWishlistSpecificText(3).getText();
		Assert.assertEquals(actualText2, expectedText2);
	}

//	@Test(priority = 10)
	public void removeWishlist() throws InterruptedException {
		String expectedText = citacIzExcela.getStringData("TS My wish list", 32, 4);
		String actualText;

		add2Wishlist();
		Thread.sleep(2000);
		myWishlistPage.clickSpecificDeleteBtn(3);
		myWishlistPage.clickOKDelete();
		Thread.sleep(1000);
		myWishlistPage.clickSpecificDeleteBtn(2);
		myWishlistPage.clickOKDelete();
		Thread.sleep(2000);

		actualText = myWishlistPage.getWishlistSpecificText(1).getText();
		Assert.assertEquals(actualText, expectedText);
	}

	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}

}
