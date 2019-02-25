/*TC_004   :To verify that the user is able to Sign-in into all the Google apps 
 *          (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Calendar, Google+, Translate, Photos)
 *          To verify that the user is able to Sign-in into all the Google apps (My Account, Search, Maps, YouTube, Play, News, Gmail, Drive, Calendar, Google+, Translate, Photos)
 * Author  :Ganesh D Pawale
 * Date    :1-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */package DD_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_004 extends Test_Core{

@BeforeTest
	
	public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_004"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}
    @Test(dataProvider="getData")
    public void account_Verification(String mailid,String passward,String username) throws InterruptedException
    {
    	 String Actual_username,Expected_username,Actual_mailid,Expected_mailid,myaccount_page_title,search_page_title,googlemap_page_title,youtube_page_title,google_play_title,google_news_page_title;
    	 
    	/* //Login MyAccount app..........
    	 google_App_Icon_Click();
    	 driver.findElement(By.xpath(object.getProperty("flag_app_my_account"))).click();
    	 driver.manage().deleteAllCookies();
    	 myaccount_page_title=driver.getTitle();
    	 signIn_Button_Present();
    	 account_Login(mailid,passward);
    	 image_icon();
    	 Actual_username=driver.findElement(By.xpath(object.getProperty("my_account_username"))).getText();
    	 Actual_mailid=driver.findElement(By.xpath(object.getProperty("my_account_mailid"))).getText();
    	 
    	 Expected_username=username;
    	 Expected_mailid=mailid;

    	 if(Actual_username.equalsIgnoreCase(Expected_username))
    	 {
    		 System.out.println(myaccount_page_title+ "Page Actual username is equal to Expected username");
    	 }
    	 else
    	 {
    		 System.out.println(myaccount_page_title+ "Page Actual username is not equal to Expected username");
    	 }
    	 if(Actual_mailid.equalsIgnoreCase(Expected_mailid))
    	 {
    		 System.out.println(myaccount_page_title+ "Page Actual_mailid is equal to Expected MailId");
    	 }
    	 else
    	 {
    		 System.out.println(myaccount_page_title+ "Page Actual_mailid is not equal to Expected MailId");
    	 }
    	 account_Logoff();
         System.out.println(".....................................................................");

    	 //Log_off MyAccount app..........
    	 
    	 //Login Search app..........
    	 google_Home();
    	 google_App_Icon_Click();
    	 driver.findElement(By.xpath(object.getProperty("flag_app_search"))).click();
    	 driver.manage().deleteAllCookies();
    	 search_page_title=driver.getTitle();
    	 signIn_Button_Present();
    	 account_Login(mailid,passward);
    	 image_icon();
    	 Actual_username=driver.findElement(By.xpath(object.getProperty("my_account_username"))).getText();
    	 Actual_mailid=driver.findElement(By.xpath(object.getProperty("my_account_mailid"))).getText();
    	 
    	 Expected_username=username;
    	 Expected_mailid=mailid;

    	 if(Actual_username.equalsIgnoreCase(Expected_username))
    	 {
    		 System.out.println(search_page_title+ " Page Actual username is equal to Expected username");
    	 }
    	 else
    	 {
    		 System.out.println(search_page_title+ " Page Actual username is not equal to Expected username");
    	 }
    	 if(Actual_mailid.equalsIgnoreCase(Expected_mailid))
    	 {
    		 System.out.println(search_page_title+ " Page Actual_mailid is equal to Expected MailId");
    	 }
    	 else
    	 {
    		 System.out.println(search_page_title+ " Page Actual_mailid is not equal to Expected MailId");
    	 }
    	 account_Logoff();
         System.out.println(".....................................................................");
    	 //Log_off Search app..........
*/    	 
         /*//Login google Map app..........
    	 google_Home();
    	 google_App_Icon_Click();
    	 driver.findElement(By.xpath(object.getProperty("flag_app_maps"))).click();
    	 driver.manage().deleteAllCookies();
    	 googlemap_page_title=driver.getTitle();
    	 signIn_Button_Present();
    	 account_Login(mailid,passward);
    	 image_icon();
    	 Actual_username=driver.findElement(By.xpath(object.getProperty("my_account_username"))).getText();
    	 Actual_mailid=driver.findElement(By.xpath(object.getProperty("my_account_mailid"))).getText();
    	 
    	 Expected_username=username;
    	 Expected_mailid=mailid;

    	 if(Actual_username.equalsIgnoreCase(Expected_username))
    	 {
    		 System.out.println(googlemap_page_title+ " Page Actual username is equal to Expected username");
    	 }
    	 else
    	 {
    		 System.out.println(googlemap_page_title+ " Page Actual username is not equal to Expected username");
    	 }
    	 if(Actual_mailid.equalsIgnoreCase(Expected_mailid))
    	 {
    		 System.out.println(googlemap_page_title+ " Page Actual_mailid is equal to Expected MailId");
    	 }
    	 else
    	 {
    		 System.out.println(googlemap_page_title+ " Page Actual_mailid is not equal to Expected MailId");
    	 }
    	 account_Logoff();
    	 System.out.println(".....................................................................");
    	 //Log_off Google Map app..........
*/
    	 //Log_off YouTube app.......... 
    	// google_Home();
    	 google_App_Icon_Click();
    	 driver.findElement(By.xpath(object.getProperty("flag_app_youtube"))).click();
    	 
    	 youtube_page_title=driver.getTitle();
    	 driver.findElement(By.xpath("//*[@id='yt-masthead-signin']/div/button")).click();
    	 //signIn_Button_Present();
    	 /*account_Login(mailid,passward);
    	 image_icon();
    	 Actual_username=driver.findElement(By.xpath(object.getProperty("my_account_username"))).getText();
    	 Actual_mailid=driver.findElement(By.xpath(object.getProperty("my_account_mailid"))).getText();
    	 
    	 Expected_username=username;
    	 Expected_mailid=mailid;

    	 if(Actual_username.equalsIgnoreCase(Expected_username))
    	 {
    		 System.out.println(youtube_page_title+ " Page Actual username is equal to Expected username");
    	 }
    	 else
    	 {
    		 System.out.println(youtube_page_title+ " Page Actual username is not equal to Expected username");
    	 }
    	 if(Actual_mailid.equalsIgnoreCase(Expected_mailid))
    	 {
    		 System.out.println(youtube_page_title+ " Page Actual_mailid is equal to Expected MailId");
    	 }
    	 else
    	 {
    		 System.out.println(youtube_page_title+ " Page Actual_mailid is not equal to Expected MailId");
    	 }
    	 account_Logoff();
    	 */
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	// Log_off YouTube app..........
    	
    	/* //LogIn Google Play app..........
    	 google_Home();
    	 google_App_Icon_Click();
    	 driver.findElement(By.xpath(object.getProperty("flag_app_play"))).click();
    	 driver.manage().deleteAllCookies();
    	 google_play_title=driver.getTitle();
    	 signIn_Button_Present();
    	 account_Login(mailid,passward);
    	 image_icon();
    	 Actual_username=driver.findElement(By.xpath(object.getProperty("my_account_username"))).getText();
    	 Actual_mailid=driver.findElement(By.xpath(object.getProperty("my_account_mailid"))).getText();
    	 
    	 Expected_username=username;
    	 Expected_mailid=mailid;

    	 if(Actual_username.equalsIgnoreCase(Expected_username))
    	 {
    		 System.out.println(google_play_title+ " Page Actual username is equal to Expected username");
    	 }
    	 else
    	 {
    		 System.out.println(google_play_title+ " Page Actual username is not equal to Expected username");
    	 }
    	 if(Actual_mailid.equalsIgnoreCase(Expected_mailid))
    	 {
    		 System.out.println(google_play_title+ " Page Actual_mailid is equal to Expected MailId");
    	 }
    	 else
    	 {
    		 System.out.println(google_play_title+ " Page Actual_mailid is not equal to Expected MailId");
    	 }
    	 account_Logoff();
    	 System.out.println(".....................................................................");
    	 //Log_off Google Play app..........
    	 
    	 //Login News app..........
    	 google_Home();
    	 google_App_Icon_Click();
    	 driver.findElement(By.xpath(object.getProperty("flag_app_news"))).click();
    	 driver.manage().deleteAllCookies();
    	 google_news_page_title=driver.getTitle();
    	 signIn_Button_Present();
    	 account_Login(mailid,passward);
    	 image_icon();
    	 Actual_username=driver.findElement(By.xpath(object.getProperty("my_account_username"))).getText();
    	 Actual_mailid=driver.findElement(By.xpath(object.getProperty("my_account_mailid"))).getText();
    	 
    	 Expected_username=username;
    	 Expected_mailid=mailid;

    	 if(Actual_username.equalsIgnoreCase(Expected_username))
    	 {
    		 System.out.println(google_news_page_title+ " Page Actual username is equal to Expected username");
    	 }
    	 else
    	 {
    		 System.out.println(google_news_page_title+ " Page Actual username is not equal to Expected username");
    	 }
    	 if(Actual_mailid.equalsIgnoreCase(Expected_mailid))
    	 {
    		 System.out.println(google_news_page_title+ " Page Actual_mailid is equal to Expected MailId");
    	 }
    	 else
    	 {
    		 System.out.println(google_news_page_title+ " Page Actual_mailid is not equal to Expected MailId");
    	 }
    	 account_Logoff();
         System.out.println(".....................................................................");

    	 //Log_off News app..........
*/    	 
    	 
   	 }
    
    
    
    @DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_009");
	}

@AfterTest
public void close()
{
	//driver.close();
}
	
}
