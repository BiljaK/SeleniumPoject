package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistPage {
	WebDriver driver;

	public MyWishlistPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWishListNameField() {
		return driver.findElement(By.id("name"));
	}

	public void addNewWishlistName(String nameWL) {
		this.getWishListNameField().sendKeys(nameWL);

	}

	public void clickSaveBtn() {
		WebElement saveBtn = driver.findElement(By.id("submitWishlist"));
		saveBtn.click();
	}

	public void add2WishlistName(String nameWL2) {
		this.getWishListNameField().sendKeys(nameWL2);

	}

	public void add3WishlistName(String nameWL3) {
		this.getWishListNameField().sendKeys(nameWL3);

	}

	public WebElement getWishlistSpecificText(int row) {
		return driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[" + row + "]/td[1]/a"));
	}

	public void clickOKDelete() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public WebElement getDeleteBtnByNum(int row) {
		return driver.findElement(
				By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[" + row + "]/td[6]/a"));
	}

	public void clickSpecificDeleteBtn(int btnNum) {
		this.getDeleteBtnByNum(btnNum).click();
	}
}
