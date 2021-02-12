package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	WebElement logOutTab;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogOutTab() {
		return driver.findElement(By.className("logout"));
	}

	public void clickLogOutBtn() {
		getLogOutTab().click();
	}

	public void clickOnMyAddressBtn() {
		WebElement myaddressesBtn = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span"));
		myaddressesBtn.click();
	}

	public void clickOnMyWishlistBtn() {
		WebElement myWishListBtn = driver.findElement(By.className("lnk_wishlist"));
		myWishListBtn.click();

	}

	public void clickMyPersonalBtn() {
		WebElement myPersonaInfoBtn = driver
				.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
		myPersonaInfoBtn.click();
	}
}
