package dropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class nonselect {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
    ExtentSparkReporter html;
	
	
	@BeforeMethod
	public void launchurl()
	{
		
		System.setProperty("webdriver.chrome.driver", "E://chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().window().maximize();
		html=new ExtentSparkReporter("extent.html");
		report = new ExtentReports();
		report.attachReporter(html);
	}
  @Test
  @Parameters("dropdown")
  public void selectdropdown(String dropdown) {
	 test= report.createTest("MyFirstTest");
	  

	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.findElement(By.id("menu2")).click();
	 test.log(Status.INFO, "test started cliked the tutorial button");

	  
	  List<WebElement> boot=driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li/a"));
	  for(int i=0; i<boot.size(); i++)
	  {
		  WebElement bootdrop=boot.get(i);
		  String innertext=bootdrop.getAttribute("innerHTML");
		  System.out.println(innertext);
		  if(innertext.contentEquals(dropdown))
		  {
			  bootdrop.click();
			  break;
			 
			

			  
		  }
	  }
	  test.pass("drop down button is clicked");
		report.flush();

  }
  
  @AfterMethod
  public void teardown()
  {
	driver.close();  
  }
}
