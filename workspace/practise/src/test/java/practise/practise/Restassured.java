package practise.practise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Restassured {
  WebDriver driver;
  
  @BeforeTest
  public void launch()
  {
    System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
    driver.get("");
    driver.manage().window().maximize();
  }
  
  @Test
  public void f() {
  }
}
