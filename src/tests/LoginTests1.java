package tests;

import org.testng.annotations.Test;

public class LoginTests1 extends TestBase {
	
	@Test
	public void Login() throws InterruptedException {
		
		driver.navigate().to("https://www.google.rs/");
		Thread.sleep(1000);
	}

}
