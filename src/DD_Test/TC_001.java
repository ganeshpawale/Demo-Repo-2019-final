/*TC_001   :To verify that the Google web page is launched successfully
 * Author  :Ganesh D Pawale
 * Date    :31-May-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */
package DD_Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_001 extends Test_Core{

	@BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_001"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}
	
	@Test(priority=1)
	public void google_Launch() throws IOException
	{
	
		    System.out.println("*********************TC_001 Execution Start*********************");
		   
			app_log.debug("Executing Google Page Launched Successfully");
			
			
			boolean flag_Sign_in_btn, flag_google_textbox, flag_google_Search_btn, flag_google_lucky_btn;
			
			
			flag_Sign_in_btn=isElementPresent(By.xpath(object.getProperty("flag_Sign_in_btn_rs")));
			
			flag_google_textbox=isElementPresent(By.xpath(object.getProperty("flag_google_textbox_rs")));
			
			flag_google_Search_btn=isElementPresent(By.xpath(object.getProperty("flag_google_Search_btn_rs")));
		
			flag_google_lucky_btn=isElementPresent(By.xpath(object.getProperty("flag_google_lucky_btn_rs")));
			
		
			if(flag_Sign_in_btn){
			
				System.out.println("Sign in button is present on web page");
			}
			
			if(flag_google_textbox){
				
				System.out.println("Google TextBox is present on web page");
			}
			if(flag_google_Search_btn){
				
				System.out.println("Search button is present on web page");
			}
            if(flag_google_lucky_btn){
				
				System.out.println("I'm Feeling Lucky button is present on web page");
			}
			
			if(flag_Sign_in_btn && flag_google_textbox && flag_google_Search_btn && flag_google_lucky_btn)
			{
				
				System.out.println("All Elements are Presents on Google Page");
				
				System.out.println("Google web page is launched successfully-Passed");
				
				app_log.debug("Google web page is launched successfully-Passed");
			}
			else
			{
			    System.out.println("All Element is not Present on Google Page-Failed");
			    
				app_log.debug("Error! Google Page not Launched Successfully-Failed");
			
			}
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_001");
	}
	@AfterTest
	public void close()
	{
		//driver.close();
	}
}
