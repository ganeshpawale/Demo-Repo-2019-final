/*TC_010   :To verify the total no. of emails received by the user
 * Author  :Ganesh D Pawale
 * Date    :4-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */
package DD_Test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_010 extends Test_Core{

	@BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_011"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}
	
	@Test(dataProvider="getData")
	public void emailCount(String mailid,String passward,String username) throws InterruptedException
	{
		System.out.println("*********************TC_010 Execution Start*********************");
	    	account_Login(mailid,passward);
			String total_string=driver.findElement(By.xpath(object.getProperty("actual_number_string"))).getText();
		
			//System.out.println("String is :::"+total_string);
			
			String s1=total_string.trim().substring(8);
		    //System.out.println("Actual number is ::::"+s1);
		    int actual_mail=Integer.valueOf(s1);
			
		int total_mail = 0,count = 0,counter=0;
		//int i=0;
		boolean btn_status=driver.findElement(By.cssSelector(object.getProperty("right_direction"))).isEnabled();
		do
		{
			 if(btn_status) 
			    {
			    	Thread.sleep(3000);
			    	driver.findElement(By.cssSelector(object.getProperty("right_direction"))).click();
			    
			    }
			
		    WebElement tables=driver.findElement(By.className("UI"));
		    List<WebElement> element=tables.findElements(By.tagName("tr"));
		    
		     count=element.size();
		    
		    total_mail=total_mail+count;
		    
		   
		    
		    // counter=counter+1; 
      }
		while(total_mail!=actual_mail);
		
		System.out.println("Total Mail is ::: "+total_mail);
		
		//System.out.println("Counter value :: "+counter);
		
		
	}	    
    	
		

	@DataProvider 
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_009");
	}
	
	
}
