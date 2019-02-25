/*TC_009   :To verify that user is able to login to Gmail
 * Author  :Ganesh D Pawale
 * Date    :5-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */
package DD_Test;

import java.awt.Button;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_009_mozila extends Test_Core {


@BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_009"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}

  @Test(dataProvider="getData")
  public void user_Login_Gmail(String mailid,String passward,String username) throws InterruptedException
  {
	  System.out.println("*********************TC_009 Execution Start*********************");
	  app_log.debug("Executing Gmail login Successfully");
	  boolean slider_bar,inbox;
	  String expected_Uname;
	  String actual_Uname;
      app_log.debug("Executing Gmail Login Launched Successfully");
      //driver.manage().window().maximize();
      driver.navigate().to("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
      driver.findElement(By.xpath(object.getProperty("mail_id"))).sendKeys(mailid);
      driver.findElement(By.xpath(object.getProperty("next"))).click();
      Thread.sleep(4000); 
      WebElement e=driver.findElement(By.xpath(object.getProperty("check_box")));
      if(e.isSelected()==true)
      {
    	  e.click();
      }
      else
      {
    	System.out.println("CheckBox Previously Uncheck");  
      }
      
      driver.findElement(By.xpath(object.getProperty("pass"))).sendKeys(passward);
      driver.findElement(By.xpath(object.getProperty("submit"))).submit();
      Thread.sleep(5000);
      driver.findElement(By.xpath(object.getProperty("image_click"))).click();
      String gmail_txt=driver.findElement(By.xpath(object.getProperty("gmail_txt"))).getText();
      System.out.println(gmail_txt);
      //WebElement str= driver.findElement(By.xpath(object.getProperty("mail_id")));
     
      if(((String) gmail_txt).equalsIgnoreCase("selweb55@gmail.com"))
      {
    	  System.out.println("Correct");
      }
      else
      {
    	  System.out.println("Uncorrect");
      }
      
      List<WebElement> element=driver.findElements(By.xpath(object.getProperty("slider_element")));
      for(WebElement el:element)
      {
    	  System.out.println(el.getText());
      }
      slider_bar=isElementPresent(By.xpath(object.getProperty("slider_bar")));
      
      if(slider_bar)
      {
    	  System.out.println("Slider_Bar is Present :"+slider_bar);  
      }
      else
      {
    	  System.out.println("Slider_Bar is not Present:"+slider_bar);
      }
      inbox=isElementPresent(By.xpath(object.getProperty("inbox")));
      if(inbox)
      {
    	  System.out.println("Inbox is Present :"+inbox);  
      }
      else
      {
    	  System.out.println("Inbox is not Present:"+inbox);
      }
     
      expected_Uname=username;
      System.out.println("Expected_uid:"+expected_Uname);
      actual_Uname=driver.findElement(By.xpath(object.getProperty("actual_user_name"))).getText();
      System.out.println("Actual_uid:"+actual_Uname);
      if(expected_Uname.equals(actual_Uname))
      {
    	  System.out.println("Gmail Expected and Actual username Equal");
      
    	  if(inbox && slider_bar)
    	  
    	  System.out.println("Gmail account login Succesfully-passed");
      }
      else
      {
    	  System.out.println("Gmail account login Unsucessfully-Failed");
    	  System.out.println("Gmail Expected and Actual username not Equal");
      }
      
      account_Logoff();
  }
  
  
	
  @DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_009");
	}
}
