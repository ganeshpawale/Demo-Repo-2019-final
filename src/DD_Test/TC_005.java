package DD_Test;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_005 extends Test_Core {

@BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_005"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}
	
    @Test(priority=5)
    public void google_Language()
    {
    	
    	boolean flag_sign_in_btn,flag_google_search_btn,flag_google_lucky_btn;
    	
    	   //Start Hindi
    	    driver.findElement(By.xpath(object.getProperty("lagu_hindi"))).click();
    	    System.out.println("You click Hindi Language");
    		flag_sign_in_btn=isElementPresent(By.xpath(object.getProperty("flag_sign_in_btn")));
		
    		flag_google_search_btn=isElementPresent(By.xpath(object.getProperty("flag_google_search_btn")));
    	
    		flag_google_lucky_btn=isElementPresent(By.xpath(object.getProperty("flag_google_lucky_btn")));
    		if(flag_sign_in_btn && flag_google_search_btn && flag_google_lucky_btn)
    		{
    			System.out.println("All Webelement should be present on Google Page");
    		}
    		else
    		{
    			System.out.println("All Webelement should not present on Google Page");
    		}
    	   //End Hindi
    		System.out.println("..........................................................................................");
    		
    		//Start Marathi
    		driver.findElement(By.xpath(object.getProperty("lagu_marathi"))).click();
    	    System.out.println("You click Marathi Language");
    	    flag_sign_in_btn=isElementPresent(By.xpath(object.getProperty("flag_sign_in_btn")));
    		
    		flag_google_search_btn=isElementPresent(By.xpath(object.getProperty("flag_google_search_btn")));
    	
    		flag_google_lucky_btn=isElementPresent(By.xpath(object.getProperty("flag_google_lucky_btn")));
    		if(flag_sign_in_btn && flag_google_search_btn && flag_google_lucky_btn)
    		{
    			System.out.println("All Webelement should be present on Google Page");
    		}
    		else
    		{
    			System.out.println("All Webelement should not present on Google Page");
    		}
    		//End marathi-
    		System.out.println("..........................................................................................");
    		//Start Gujrati
    		driver.findElement(By.xpath(object.getProperty("lagu_gujrati"))).click();
    	    System.out.println("You click Gujrati Language");
    		
    		flag_sign_in_btn=isElementPresent(By.xpath(object.getProperty("flag_sign_in_btn")));
		
    		flag_google_search_btn=isElementPresent(By.xpath(object.getProperty("flag_google_search_btn")));
    	
    		flag_google_lucky_btn=isElementPresent(By.xpath(object.getProperty("flag_google_lucky_btn")));
    	
    		if(flag_sign_in_btn && flag_google_search_btn && flag_google_lucky_btn)
    		{
    			System.out.println("All Webelement should be present on Google Page");
    		}
    		else
    		{
    			System.out.println("All Webelement should not present on Google Page");
    		}
    	  //End Gujrati
       
    }
}
