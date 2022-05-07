package practise.practise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Restassured {
	WebDriver driver;
	@BeforeTest
	public void  entertintappliacyion()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	}
  @Test
  public void f() {
  }
}
