package practise.practise;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excelsheetreader {
	WebDriver driver;
	
	@BeforeTest
	public void launchapp()
	{
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://www.linkedin.com/checkpoint/lg/sign-in-another-account");
	driver.manage().window().maximize();
	}

	@Test(dataProvider="dataprovider")
	public void enterdetails(String name,String password)throws Throwable
	{
	WebElement username=driver.findElement(By.id("username"));
	WebElement pasword=driver.findElement(By.id("password"));
	username.clear();
	username.sendKeys(name);
	
	pasword.clear();
	pasword.sendKeys(password);
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	Thread.sleep(4000);
	
	try
	{
		String tittle=driver.getTitle();
		System.out.println( "current page tittle is:"+tittle);

		Actions ac=new Actions(driver);

		Thread.sleep(4000);
		WebElement messagebutton=driver.findElement(By.xpath("//h3[text()='Sai Chaitanya B']/parent::div/parent::div"));
		Thread.sleep(4000);
		if(messagebutton.isDisplayed()){
			System.out.println("messagebutton is dsiplayed");
			messagebutton.click();

		     Thread.sleep(4000);
		     WebElement saichaitnaya=driver.findElement(By.xpath("//span[text()='Sai Chaitanya B']/parent::a/parent::h2/parent::div"));
		      if(saichaitnaya.isDisplayed())
		     {
		    	 System.out.println("In saichaitnaya box");
		    	WebElement searchlab= driver.findElement(By.cssSelector("div[role='textbox']"));
		    	Thread.sleep(4000);
		    	ac.moveToElement(searchlab);
		    	 searchlab.sendKeys("rey rey rey");
		    	 Thread.sleep(4000);
		    	 WebElement sendbuuton=driver.findElement(By.cssSelector("button[type='submit']"));
		    	 sendbuuton.click();
		     }
		     
		     
		}
		else
		{
			System.out.println("unable to find the elements");
		}
		Thread.sleep(4000);
	}
	catch(Exception e)
	{
		System.out.println("unable to find the chatbox"+e.getMessage());
	}
	}
	
  @DataProvider(name="dataprovider")
  public Object[][] gettestdata() {
	  Object[][] data={{"partheepbommina@gmail.com","saintpartheep"}};
	  return data;
  }
  
  @AfterTest
  public void closeapp()
  {
	  driver.close();
  }
}
