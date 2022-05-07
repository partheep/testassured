package practise.practise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class newpractise {
	WebDriver driver;
	@BeforeTest
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver.get("htpps://google.com");
		driver.manage().window().maximize();
	}
  @Test
  public void vaidate() {
	  
	  String expected=driver.getTitle();
	  String actual=expected;
	  if(actual.contains(expected))
	  {
		  System.out.println("Test case is passed");
	  }
  }
  
  
  @AfterTest
  public void teardown()
  {
	  driver.close();
  }
}
