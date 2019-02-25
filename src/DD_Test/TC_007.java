/*TC_007   : To validate that the Google performs the search operation properly
 * Author  :Ganesh D Pawale
 * Date    :4-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */package DD_Test;
import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_007 extends Test_Core
{
	@BeforeTest
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_007"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}	
	
	@Test(dataProvider="getData",priority=7)
	public void name_Verification(String Search_Name)
	{
		 System.out.println("*********************TC_007 Execution Start*********************");
	        
	        app_log.debug("Executing Search_box Launched Successfully");
		System.out.println();
		driver.findElement(By.xpath(object.getProperty("flag_google_textbox_rs"))).sendKeys(Search_Name);
		driver.findElement(By.xpath(object.getProperty("flag_search_click"))).sendKeys(Keys.ENTER);
		
		List<WebElement> Flag_links = driver.findElements(By.className("r"));		
		
		
		 for (int i=0;i<Flag_links.size();i++)  
		 	 
			System.out.println(Flag_links.get(i).getText());
	
		 
		 List<String> links = new ArrayList<String>();
		 
	       for(WebElement e : Flag_links)
	       {
	    	   links.add(e.getText());
	       }  
	       for (int i = 0; i < links.size(); i++) 
	       {
	           System.out.println(links.get(i));
	        }
		 System.out.println("................................................................");
		 
		 if(links.toString().contains(Search_Name))
		 {
		         System.out.println("System perform search Operation Clearly,keyword is :"+Search_Name);
		         app_log.debug("System find Keyword Properly-Passed");
		 }
		 else
		 {
			 System.out.println("System doesn't perform search,Operation,keyword is :"+Search_Name);
			 app_log.debug("System not find Keyword -Failed");
		 }
		
	}
	
	@DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_007");
	}
}
