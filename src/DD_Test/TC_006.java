/*TC_006   :To open and close the browser
 * Author  :Ganesh D Pawale
 * Date    :4-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */
package DD_Test;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_006 extends Test_Core{

		@BeforeTest
		public void isSkip()
		{
			if(!Test_Util.isExecutable("TC_006"))
			{
				throw new SkipException("Skiping the test case as run mode set to NO");
			}
		}	
		
		@Test(priority=6,dataProvider="getData")
	    public void google_page(String expected_title) throws InterruptedException
			{
			 System.out.println("*********************TC_006 Execution Start*********************");
		        
		       app_log.debug("Executing Browser is Launched Successfully");		    	
		       //driver.manage().window().maximize();
		    
				   Thread.sleep(4000L);
				  // driver.close();
				   System.out.println("Browser is Closed");
			       
				   String actual_title=driver.getTitle();
				   if(expected_title.equals(actual_title))
				   {
					   //System.out.println("Page found");
					   System.out.println("Browser is Opened-Passed");
				   }
				   else
				   {
					   //System.out.println("Page not found");
					   System.out.println("Browser is not Opened-Failed");
				   }
			       
				
		   
			}
	
	    @DataProvider
		public static Object[][] getData()
		{
			return Test_Util.getData("TC_006");
		}
    
}		
	
