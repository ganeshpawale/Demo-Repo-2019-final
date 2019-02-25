/*TC_009   :To verify that user is able to login to Gmail
 * Author  :Ganesh D Pawale
 * Date    :4-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */ 
package DD_Test;
    import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.SkipException;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import DD_Core.Test_Core;
	import DD_Util.Test_Util;

	public class TC_009 extends Test_Core {


	@BeforeTest
		
		public void isSkip()
		{
			if(!Test_Util.isExecutable("TC_009"))
			{
				throw new SkipException("Skiping the test case as run mode set to NO");
			}
		}

	  @Test(priority=9,dataProvider="getData")
	  public void user_Login_Gmail(String mailid,String passward,String username) throws InterruptedException
	  {
		  System.out.println("*********************TC_009 Execution Start*********************");
		  boolean slider_bar,inbox;
		  String expected_Uname;
		  String actual_Uname;
		 
	      app_log.debug("Executing Gmail Login Launched Successfully");
	      //driver.manage().window().maximize();
	      driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
	      driver.findElement(By.xpath(object.getProperty("mail_id1"))).sendKeys(mailid);
	      driver.findElement(By.cssSelector(object.getProperty("next1"))).click();
	     
	      
	      driver.findElement(By.xpath(object.getProperty("pass1"))).sendKeys(passward);
	      driver.findElement(By.cssSelector(object.getProperty("submit1"))).click();
	      //driver.findElement(By.cssSelector("#passwordNext > content > span")).click();
	      Thread.sleep(5000);
	
	      
	      driver.findElement(By.xpath(object.getProperty("image_click1"))).click();
	      String gmail_txt=driver.findElement(By.xpath(object.getProperty("gmail_txt1"))).getText();
	      System.out.println("User Name is :"+gmail_txt);
	      //WebElement str= driver.findElement(By.xpath(object.getProperty("mail_id")));
	     
	      
	      
	      List<WebElement> element=driver.findElements(By.xpath(object.getProperty("slider_element1")));
	      System.out.println("Slider Content are:");
	      for(WebElement el:element)
	      {
	    	  System.out.println(el.getText());
	      }
	      slider_bar=isElementPresent(By.xpath(object.getProperty("slider_bar1")));
	      
	      if(slider_bar)
	      {
	    	  System.out.println("Slider_Bar is Present :"+slider_bar);  
	      }
	      else
	      {
	    	  System.out.println("Slider_Bar is not Present:"+slider_bar);
	      }
	      inbox=isElementPresent(By.xpath(object.getProperty("inbox1")));
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
	      actual_Uname=driver.findElement(By.xpath(object.getProperty("actual_user_name1"))).getText();
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
	      //Logoff method
	      account_Logoff();
	  }
	  
	  
		
	  @DataProvider
		public static Object[][] getData()
		{
			return Test_Util.getData("TC_009");
		}
}

	

