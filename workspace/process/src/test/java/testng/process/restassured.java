package testng.process;

import org.testng.annotations.AfterTest;
import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class restassured {
	Response response;
	
	@BeforeTest
	public void hiturl()
	{
	 response=	get("https://reqres.in/api/users?page=2");
	}
  @Test
  public void f() {
	  
	int  Statuscode= response.getStatusCode();
	System.out.println("statuscode  hitted"+Statuscode);
	String statuscodestring=response.asString();
	System.out.println(statuscodestring);
	String statusline=response.toString();
	System.out.println("status line is "+statusline);
	if(200==Statuscode)
	{
		System.out.println("status code is hitted");
		Assert.assertEquals(Statuscode, 200);
	}
	else
	{
		Assert.fail("Apis are not hitted");
	}
  }
  @Test
  public void secondvalidate()
  {
	  baseURI="https://reqres.in/api";
	  given().
	  get("/users?page=2").then().statusCode(200).
	  body("data[1].id", equalTo(5));
  }
  @AfterTest
  public void close()
  {
	  
  }
}
