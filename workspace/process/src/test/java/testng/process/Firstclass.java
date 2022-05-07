package testng.process;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Firstclass {
	WebDriver driver;
  Actions ac;
	@BeforeTest
	public void startbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://google.com");
		driver.manage().window().maximize();
		
	}
  @Test
  public void tiltlevalidation() {
	 String expected= driver.getTitle();
	 String actual="Google";
	 if(actual.equalsIgnoreCase(expected)){
	 Assert.assertEquals(actual, expected, "tiltle is not matching as expected");
	 }
	 else
	 {
		 System.out.println("not find actual tittle in that page");
	 }
  }
	 @Test
	 public void validation(){
		 String expected=driver.getCurrentUrl();
		 String actual=expected;
		 Assert.assertEquals(actual, expected);
	 }
  
  @Test
  @Parameters({"xpath"})
  public void validatext(@Optional("//input[@title='Search']") String xpath)
  
  {
	 

System.out.println("xpath is printed"+xpath);
WebElement serach=driver.findElement(By.xpath(xpath));
System.out.println(serach);
serach.sendKeys("maheshbabu");

String serachtext = serach.getText();
System.out.println("serach text is"+serachtext);
ac=new Actions(driver);
ac.sendKeys(Keys.ENTER).build().perform();


  }
  @AfterTest
  public void teardown()
  {
//	  driver.close();
  }
}
