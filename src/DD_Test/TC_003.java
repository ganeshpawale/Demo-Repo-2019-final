package DD_Test;
import org.openqa.selenium.By;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_003 extends Test_Core {

    @BeforeTest
    public void isSkip()
	{
		if(!Test_Util.isExecutable("TC_003"))
		{
			throw new SkipException("Skiping the test case as run mode set to NO");
		}
	}

	@Test(priority=3,dataProvider="getData")
	public void google_Application_Verification(String pagetitle) throws InterruptedException 
	{
       String myaccount_title;

       
       boolean search_txt,search_btn,lucky_btn,map_searchbox,direction_map,youtube_icon,youtube_search_txt,youtube_upload_icon,play_icon,play_search_txt,news_icon,news_top_stories,gmail_icon,gmail_signin_btn,gmail_create_account_btn,drive_meet_btn,drive_usingdrive_btn,drive_icon,google_plus_icon,join_google_plus,translate_icon,translate_btn,google_photos_icon,go_to_google_photos_btn;
        google_App_Icon_Click();
        Thread.sleep(2000);
    
        //...[1]..start My Account app....
        driver.findElement(By.xpath(object.getProperty("flag_app_my_account"))).click();
        myaccount_title=driver.getTitle();
		//System.out.println("Myaccount_Page_Title :"+myaccount_title);
		
		if(myaccount_title.equals(pagetitle) && driver.getPageSource().contains("My Account"))
		{
			System.out.println("My account text is Present on MYACCOUNT Web Page");
		}
		else
		{
			System.out.println("My account text is not Present on MYACCOUNT Web Page");
     	}
		
		System.out.println("............................................................");
	//.....[1]End my account app.....
	
		
	//.....[2] Start Search app....
		 
		 google_Home();
		 //backAction();
		 google_App_Icon_Click();
         driver.findElement(By.xpath(object.getProperty("flag_app_search"))).click();
         search_txt=isElementPresent(By.xpath(object.getProperty("flag_google_textbox_rs")));
         search_btn=isElementPresent(By.xpath(object.getProperty("flag_google_Search_btn_rs")));
         lucky_btn=isElementPresent(By.xpath(object.getProperty("flag_google_lucky_btn_rs")));
			
         
		 if(search_txt)
			{
				System.out.println("Search textBox is Present on Search Web Page");
			}
			else
			{
				System.out.println("Search textBox is not Present on Search Web Page");
	     	}
		   
		 if(search_btn)
			{
				System.out.println("Search Botton is Present on Search Web Page");
			}
			else
			{
				System.out.println("Search Botton is not Present on Search Web Page");
	     	}
		 
		 if(lucky_btn)
			{
				System.out.println("I'm Feeling Lucky Botton is Present on Search Web Page");
			}
			else
			{
				System.out.println("I'm Feeling Lucky Botton is not Present on Search Web Page");
	     	}
		 if(search_txt && search_btn && lucky_btn)
		 {
			 System.out.println("Search Page is Present in Google Applicaation");
		 }
		 else
		 {
			 System.out.println("Search Page is not Present in Google Applicaation");
		 }
		 
		 System.out.println("............................................................");
			//.....[3] Start Map app....
		  //google_Home();
		  google_App_Icon_Click();
		  driver.findElement(By.xpath(object.getProperty("flag_app_maps"))).click();
		  //System.out.println("Map Title:"+driver.getTitle());
		  //map_title=driver.getTitle();
		  //boolean map=Boolean.valueOf(map_title);//convert string to boolean
		  //System.out.println("Boolean val:"+map);
		  //map_title=driver.getTitle();
		  map_searchbox=isElementPresent(By.xpath(object.getProperty("flag_map_searchbox")));
		  direction_map=isElementPresent(By.xpath(object.getProperty("flag_zoomIn_map")));
		
		  if(map_searchbox)
			{
				System.out.println("Map Search Box is Present on Map Web Page");
			}
			else
			{
				System.out.println("Map Search Box is not Present on Map Web Page");
	     	}if(direction_map)
			{
				System.out.println("Map Direction option is Present on Map Web Page");
			}
			else
			{
				System.out.println("Map Direction option is not Present on Map Web Page");
	     	}
	     	
	     	if(map_searchbox && direction_map)
	     	{
	     		System.out.println("Map Page is Present in Google Applicaation"); 
	     	}
	     	else
	     	{
	     		System.out.println("Map Page is not Present in Google Applicaation"); 
	     	}
	     	System.out.println("............................................................");
	     	
	     	//.....[3] End Map app....
	     	
	     	
	     	//.....[4] You Tube Map app....	
	     	google_Home();
	     	google_App_Icon_Click();
			driver.findElement(By.xpath(object.getProperty("flag_app_youtube"))).click();
			youtube_icon=isElementPresent(By.xpath(object.getProperty("flag_youtube_icon")));
			youtube_search_txt=isElementPresent(By.xpath(object.getProperty("flag_youtube_search_txt")));
			youtube_upload_icon=isElementPresent(By.xpath(object.getProperty("falg_youtube_upload_icon")));
			
			if(youtube_icon)
			{
				System.out.println("YouTube icon is Present on YouTube Web Page");
			}
			else
			{
				System.out.println("YouTube icon is not Present on YouTube Web Page");

			}
			if(youtube_search_txt)
			{
				System.out.println("YouTube Search Box is Present on YouTube Web Page");
			}
			else
			{
				System.out.println("YouTube Search Box is not Present on YouTube Web Page");

			}
			if(youtube_upload_icon)
			{
				System.out.println("YouTube Upload icon is Present on YouTube Web Page");
			}
			else
			{
				System.out.println("YouTube Upload icon is not Present on YouTube Web Page");

			}
			if(youtube_icon && youtube_search_txt && youtube_upload_icon)
			{
				System.out.println("YouTube Page is Present in Google Applicaation");
			}
			else
			{
				System.out.println("YouTube Page is not Present in Google Applicaation");
			}
			
	     	System.out.println("............................................................");

	     	//.....[4] End YouTube app....
	     	
	     	//.....[5] Start Play app....
	     	//Thread.sleep(4000);
	    google_Home();
    	google_App_Icon_Click();
		driver.findElement(By.xpath(object.getProperty("flag_app_play"))).click();
		play_icon=isElementPresent(By.xpath(object.getProperty("flag_play_icon")));
		play_search_txt=isElementPresent(By.xpath(object.getProperty("flag_play_search_txt")));
		if(play_icon)
		{
			System.out.println("Play icon is Present on Google Play Web Page");
		}
		else
		{
			System.out.println("Play icon is not Present on Google Play Web Page");

		}
		if(play_search_txt)
		{
			System.out.println("Google Play search textBox is Present on Google Play Web Page");
		}
		else
		{
			System.out.println("Google Play search textBox is not Present on Google Play Web Page");

		}
		
		if(play_icon && play_search_txt)
		{
			System.out.println("Google Play Page is Present in Google Applicaation");

		}
		else
		{
			System.out.println("Google Play Page is not Present in Google Applicaation");	
		}
       
		System.out.println("............................................................");

     	//.....[5] End Play app....
       
     
		//.....[6] Start News app....
		//google_Home();
		google_App_Icon_Click();
		driver.findElement(By.xpath(object.getProperty("flag_app_news"))).click();
		news_icon=isElementPresent(By.xpath(object.getProperty("flag_news_icon")));
		news_top_stories=isElementPresent(By.xpath(object.getProperty("flag_news_top_stories")));
       
		if(news_icon)
		{
			System.out.println("News icon is Present on News Web Page");
		}
		else
		{
			System.out.println("News icon is not Present on News Web Page");

		}
		if(news_top_stories)
		{
			System.out.println("Top Stories is Present on News Web Page");
		}
		else
		{
			System.out.println("Top Stories is not Present on News Web Page");

		}
		
		if(news_icon && news_top_stories)
		{
			System.out.println("News Page is Present in Google Applicaation");

		}
		else
		{
			System.out.println("News Page is not Present in Google Applicaation");	
		}
		
		System.out.println("............................................................");

     	//.....[6] End News app....
       
	 	//.....[7] Star Gmail app....
       //google_Home();
       driver.navigate().to("https://www.google.com/gmail/about/");;
		
		//driver.manage().deleteAllCookies();
		//google_App_Icon_Click();
		//driver.navigate().to("https://www.google.com/gmail/about/");
		//driver.findElement(By.xpath(object.getProperty("flag_app_gmail"))).click();
		gmail_icon=isElementPresent(By.xpath(object.getProperty("flag_gmail_icon")));
		gmail_signin_btn=isElementPresent(By.xpath(object.getProperty("flag_gmail_signin_btn")));
		gmail_create_account_btn=isElementPresent(By.xpath(object.getProperty("flag_gmail_create_account_btn")));
       
		if(gmail_icon)
		{
			System.out.println("Gmail icon is Present on Gmail Web Page");
		}
		else
		{
			System.out.println("Gmail icon is not Present on Gmail Web Page");

		}
		if(gmail_signin_btn)
		{
			System.out.println("Gmail Signin button is Present on Gmail Web Page");
		}
		else
		{
			System.out.println("Gmail Signin button is not Present on Gmail Web Page");

		}
		if(gmail_create_account_btn)
		{
			System.out.println("Gmail Create account button is Present on Gmail Web Page");
		}
		else
		{
			System.out.println("Gmail Create account button is not Present on Gmail Web Page");

		}
		
		if(gmail_icon && gmail_signin_btn && gmail_create_account_btn)
		{
			System.out.println("Gmail Page is Present in Google Applicaation");

		}
		else
		{
			System.out.println("Gmail Page is not Present in Google Applicaation");	
		}
		
		System.out.println("............................................................");

		//.....[7] End Gmail app....
	
		//.....[8] Start Drive app....
		google_Home();
		google_App_Icon_Click();
		driver.findElement(By.xpath(object.getProperty("flag_app_driver"))).click();
		drive_meet_btn=isElementPresent(By.xpath(object.getProperty("flag_drive_meet_btn")));
		drive_usingdrive_btn=isElementPresent(By.xpath(object.getProperty("flag_drive_usingdrive_btn")));
		drive_icon=isElementPresent(By.xpath(object.getProperty("flag_drive_icon")));
       
		if(drive_meet_btn)
		{
			System.out.println("Meet Drive button is Present on Google Drive Web Page");
		}
		else
		{
			System.out.println("Meet Drive button is not Present on Google Drive Web Page");

		}
		if(drive_usingdrive_btn)
		{
			System.out.println("Using Drive button is Present on Google Drive Web Page");
		}
		else
		{
			System.out.println("Using Drive button is not Present on Google Drive Web Page");

		}
		if(drive_icon)
		{
			System.out.println("Google Drive icon is Present on Google Drive Web Page");
		}
		else
		{
			System.out.println("Google Drive icon is not Present on Google Drive Web Page");

		}
		
		if(drive_meet_btn && drive_usingdrive_btn && drive_icon)
		{
			System.out.println("Google Drive Page is Present in Google Applicaation");

		}
		else
		{
			System.out.println("Google Drive is not Present in Google Applicaation");	
		}
		
		System.out.println("............................................................");

	
		//.....[8] End Drive app....
       
		
		
		//.....[9] Start Google+ app....
				google_Home();
				google_App_Icon_Click();
				driver.findElement(By.xpath(object.getProperty("flag_app_google_plus"))).click();
				google_plus_icon=isElementPresent(By.xpath(object.getProperty("flag_google_plus_icon")));
				join_google_plus=isElementPresent(By.xpath(object.getProperty("flag_join_google_plus")));
						       
				if(google_plus_icon)
				{
					System.out.println("Google+ icon is Present on Google+ Web Page");
				}
				else
				{
					System.out.println("Google+ icon is not Present on Google+ Web Page");

				}
				if(join_google_plus)
				{
					System.out.println("Join Google button is Present on Google+ Web Page");
				}
				else
				{
					System.out.println("Join Google button is not Present on Google+ Web Page");

				}
				
				if(google_plus_icon && join_google_plus)
				{
					System.out.println("Google+ Page is Present in Google Applicaation");

				}
				else
				{
					System.out.println("Google+ Page is not Present in Google Applicaation");	
				}
				
				System.out.println("............................................................");

			
				//.....[9] End Google+ app....
		       
       
      
				//.....[10] Start Translate app....
				google_Home();
				google_App_Icon_Click();
				driver.findElement(By.xpath(object.getProperty("flag_app_translate"))).click();
				translate_icon=isElementPresent(By.xpath(object.getProperty("flag_translate_icon")));
				translate_btn=isElementPresent(By.xpath(object.getProperty("flag_translate_btn")));
						       
				if(translate_icon)
				{
					System.out.println("Translate icon is Present on Translate Web Page");
				}
				else
				{
					System.out.println("Translate icon is not Present on Translate Web Page");

				}
				if(translate_btn)
				{
					System.out.println("Translate button button is Present on Translate Web Page");
				}
				else
				{
					System.out.println("Translate button button is not Present on Translate Web Page");

				}
				
				if(translate_icon && translate_btn)
				{
					System.out.println("Translate Page is Present in Google Applicaation");

				}
				else
				{
					System.out.println("Translate Page is not Present in Google Applicaation");	
				}
				
				System.out.println("............................................................");

				
			//.....[10] End Translate app....
          
				
				//.....[11] Start Google_Photos app....
				//google_Home();
				google_App_Icon_Click();
				driver.findElement(By.xpath(object.getProperty("flag_app_google_photos"))).click();
				google_photos_icon=isElementPresent(By.xpath(object.getProperty("flag_google_photos_icon")));
				go_to_google_photos_btn=isElementPresent(By.xpath(object.getProperty("flag_go_to_google_photos_btn")));
						       
				if(google_photos_icon)
				{
					System.out.println("Google Photos icon is Present on Google Photos Web Page");
				}
				else
				{
					System.out.println("Google Photos icon is not Present on Google Photos Web Page");

				}
				if(go_to_google_photos_btn)
				{
					System.out.println("Go to Google Photos button is Present on Google Photos Web Page");
				}
				else
				{
					System.out.println("Google Photos button is not Present on Google Photos Web Page");

				}
				
				if(google_photos_icon && go_to_google_photos_btn)
				{
					System.out.println("Google Photos Page is Present in Google Applicaation");

				}
				else
				{
					System.out.println("Google Photos Page is not Present in Google Applicaation");	
				}
				
				System.out.println("............................................................");

				
				//.....[11] End Google_Photos app....
       
    
	}
	
	
	
	@DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_003");
	}
}