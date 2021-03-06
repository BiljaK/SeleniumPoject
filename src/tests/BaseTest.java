package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.ShopingCartPage;
import pages.CitacIzExcela;
import pages.DressesPage;
import pages.HomePage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyPersonalInfoPage;
import pages.MyWishlistPage;
import pages.SigninPage;
import pages.YourAddressPage;

public class BaseTest {
	WebDriver driver;
	CitacIzExcela citacIzExcela;
	HomePage homePage;
	SigninPage signinPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressPage;
	YourAddressPage yourAddressPage;
	MyPersonalInfoPage myPesonalInfoPage;
	MyWishlistPage myWishlistPage;
	DressesPage dressesPage;
	ShopingCartPage shopingCartPage;

	public void validLogIn(String email, String password) throws InterruptedException {
		Thread.sleep(1000);
		homePage.clickSignin();
		Thread.sleep(1000);
		signinPage.navigateToEmailInput(citacIzExcela.getStringData("TS Login", 9, 3));
		signinPage.navigateToPasswordInput(citacIzExcela.getStringData("TS Login", 10, 3));
		Thread.sleep(1000);
		signinPage.navigateToSiginBtn();
	}

	@BeforeClass
	public void preKlasa() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");

		this.driver = new ChromeDriver();
		citacIzExcela = new CitacIzExcela("data/testplan.xlsx");
		homePage = new HomePage(driver);
		signinPage = new SigninPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressPage = new MyAddressesPage(driver);
		yourAddressPage = new YourAddressPage(driver);
		myPesonalInfoPage = new MyPersonalInfoPage(driver);
		myWishlistPage = new MyWishlistPage(driver);
		dressesPage = new DressesPage(driver);
		shopingCartPage = new ShopingCartPage(driver);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void posleKlasa() throws IOException {
		driver.close();
		System.out.println("Kraj programa");
		citacIzExcela.fis.close();
	}
}
