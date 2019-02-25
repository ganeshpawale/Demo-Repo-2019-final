/*TC_008   :To verify the Google apps/products on Google products webpage
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
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_008 extends Test_Core{

	@BeforeTest
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_008"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}	
	
	@Test(priority=8)
	public void google_Product()
	{
		System.out.println("*********************TC_008 Execution Start*********************");
		
		app_log.debug("Google Products Page is Executing Successfully");
		
		driver.navigate().to("https://www.google.co.in/intl/en/about/products/");
		
		 List<WebElement> alllinks=driver.findElements(By.tagName("a"));
		 
		 for(WebElement link:alllinks)
		 {
			 System.out.println("\n Google Product is: "+link.getText());
	     }
			 if(!(alllinks.equals(0)))
			 {
				 
				 System.out.println("All Google Product Or Application Exist In Google Product Page-Passed");
				
			 }
			 else
			 {
				 System.out.println("\n Google Product is not found");
				 System.out.println("All Google Product Or Application Exist In Google Product Page-Failed");
			 }
		 }
		
	}
	

