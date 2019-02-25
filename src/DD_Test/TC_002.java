/*TC_002   :To verify that the Google web page is launched successfully
 * Author  :Ganesh D Pawale
 * Date    :31-May-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */
package DD_Test;
import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_002 extends Test_Core {

    @BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_002"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}
	
   
	@Test(priority=2)
	public void google_Application()
	{
	
		boolean flag_google_app,flag_app_my_account,flag_app_search,flag_app_maps,flag_app_youtube,flag_app_play,flag_app_news,flag_app_gmail,flag_app_driver,flag_app_calender,flag_app_google,flag_app_translate,flag_app_photos;
        
        System.out.println("*********************TC_002 Execution Start*********************");
        
        app_log.debug("Executing Google Application Launched Successfully");
        
		flag_google_app=isElementPresent(By.xpath(object.getProperty("flag_google_app")));
		//System.out.println(""+flag_google_app);
		
		flag_app_my_account=isElementPresent(By.xpath(object.getProperty("flag_app_my_account")));
		System.out.println("My account is Present in Dialog Box is "+flag_app_my_account);
		
		flag_app_search=isElementPresent(By.xpath(object.getProperty("flag_app_search")));
		System.out.println("Search app is Present in Dialog Box is "+flag_app_search);
		
		flag_app_maps=isElementPresent(By.xpath(object.getProperty("flag_app_maps")));
		System.out.println("Google Map is Present in Dialog Box is "+flag_app_maps);
		
		flag_app_youtube=isElementPresent(By.xpath(object.getProperty("flag_app_youtube")));
		System.out.println("YouTube is Present in Dialog Box is "+flag_app_youtube);
		
		
		flag_app_play=isElementPresent(By.xpath(object.getProperty("flag_app_play")));
		System.out.println("Google Play is Present in Dialog Box is "+flag_app_play);
		
		flag_app_news=isElementPresent(By.xpath(object.getProperty("flag_app_news")));
		System.out.println("News app is Present in Dialog Box is "+flag_app_news);
		
		flag_app_gmail=isElementPresent(By.xpath(object.getProperty("flag_app_gmail")));
		System.out.println("Gmail app is Present in Dialog Box is "+flag_app_gmail);
		
		flag_app_driver=isElementPresent(By.xpath(object.getProperty("flag_app_driver")));
		System.out.println("Google Driver is Present in Dialog Box is "+flag_app_driver);
		
		flag_app_calender=isElementPresent(By.xpath(object.getProperty("flag_app_calender")));
		System.out.println("Calendar is Present in Dialog Box is "+flag_app_calender);
		
		flag_app_google=isElementPresent(By.xpath(object.getProperty("flag_app_google_plus")));
		System.out.println("Google+ app is Present in Dialog Box is "+flag_app_google);
		
		flag_app_translate=isElementPresent(By.xpath(object.getProperty("flag_app_translate")));
		System.out.println("Translate is Present in Dialog Box is "+flag_app_translate);
		
		flag_app_photos=isElementPresent(By.xpath(object.getProperty("flag_app_google_photos")));
		System.out.println("Photo is Present in Dialog Box is "+flag_app_photos);
		
	
		
		
		
		if(flag_google_app && flag_app_my_account && flag_app_search && flag_app_maps && flag_app_youtube && flag_app_play && flag_app_news && flag_app_gmail && flag_app_driver && flag_app_calender && flag_app_google && flag_app_translate && flag_app_photos)
		{
			System.out.println(driver.getTitle()+ " application Present on Web Page");
			
			//WebElement element=driver.findElement(By.xpath("//*[@id='gbwa']/div[2]/ul[1]"));     
			
			//getLinks(By.xpath(object.getProperty("link")));
			
			System.out.println("All Application should be availabled in Google Dialog Box -Passed");
			
			app_log.debug("Google application is Presented in Dailog Box");
		}
	
	
	
		else
		{
			System.out.println("All Application should not be availabled in Google Dialog Box -Failed");
			
			app_log.debug("Google application is not Presented in Dailog Box");
		}
	
	}
		
}
	



	
	

