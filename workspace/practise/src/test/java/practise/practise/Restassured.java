package practise.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Restassured {
  WebDriver driver;
  
  @BeforeTest
  public void launch()
  {
    System.setProperty("webdriver.chrome.driver","E://chromedriver.exe");
    driver=new ChromeDriver();
driver.navigate().to("https://www.google.com");
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
  
  @Test
  public void entermaheshbabu()
  {
	  WebElement serachbar=driver.findElement(By.xpath("//input[@name='q']"));
	  Actions ac=new Actions(driver);
	  ac.sendKeys("maheshbabu").sendKeys(Keys.ENTER).perform();
	  
  }
  @AfterTest
  public void teardown()
  {
	  driver.close();
  }
}
