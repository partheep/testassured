package practise.practise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Restassured {
  WebDriver driver;
  
  @BeforeTest
  public void launch()
  {
    System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
    driver.get("https://google.com");
    driver.manage().window().maximize();
  }
  
  @Test
  public void vlidate() {
	  
	  String Expected=driver.getTitle();
	  String actual=Expected;
	  if(actual.contains(Expected))
	  {
		  System.out.println("test case validated");
	  }
	  else
	  {
		  System.out.println("not passed the values");
	  }
  }
  @AfterTest
  public void teardown()
  {
	  driver.close();
  }
}
