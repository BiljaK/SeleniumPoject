package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DressesPage {
	WebDriver driver;

	public DressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAdd1Dress() throws InterruptedException {
		WebElement add1Dress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add1Dress);
		Thread.sleep(1000);

		Actions act = new Actions(driver);
		act.moveToElement(add1Dress).perform();

		Thread.sleep(3000);
		WebElement clickAdd = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[2]/div[2]/a[1]"));
		clickAdd.click();

	}

	public void proceedToCheckOut() {
		WebElement proceedChackOut = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a"));
		proceedChackOut.click();

	}

	public WebElement getQuantityField() {
		return driver.findElement(By.xpath("//*[@id=\"product_3_13_0_446040\"]/td[5]/input[2]"));
	}

	public void addQuantity(String amount) {
		this.getQuantityField().clear();
		this.getQuantityField().sendKeys(amount);
	}

	public void addProductAndGoCart() throws InterruptedException {
		Thread.sleep(3000);
		clickAdd1Dress();
		Thread.sleep(6000);
		proceedToCheckOut();

	}

	public void clickAdd2ndDress() throws InterruptedException {
		WebElement add1Dress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add1Dress);
		Thread.sleep(1000);

		Actions act = new Actions(driver);
		act.moveToElement(add1Dress).perform();

		Thread.sleep(3000);
		WebElement clickAdd = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/div[2]/a[1]"));
		clickAdd.click();

	}

	public void clickAdd3rdDress() throws InterruptedException {
		WebElement add1Dress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", add1Dress);
		Thread.sleep(1000);

		Actions act = new Actions(driver);
		act.moveToElement(add1Dress).perform();

		Thread.sleep(3000);
		WebElement clickAdd = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[3]/div/div[2]/div[2]/a[1]"));
		clickAdd.click();

	}

	public void continueShopingBtn() {
		WebElement continueShoping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span"));
		continueShoping.click();
	}
}
