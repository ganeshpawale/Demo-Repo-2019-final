

/*TC_013   :To verify the total no. of emails marked with STAR
 * Author  :Ganesh D Pawale
 * Date    :4-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */ 

    package DD_Test;
    import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import DD_Core.Test_Core;
	import DD_Util.Test_Util;

	public class TC_011 extends Test_Core{


	@BeforeTest
		
		public void isSkip()
		{
			if(!Test_Util.isExecutable("TC_011"))
			{
				throw new SkipException("Skiping the test case as run mode set to NO");
			}
		}
	
	@Test(dataProvider="getData")
	public void user_Login_Gmail(String mailid,String passward,String username) throws InterruptedException 
	{
		System.out.println("*********************TC_011 Execution Start*********************");
		
		account_Login(mailid,passward);
		int for_count_loop;
		
		String total_string=driver.findElement(By.xpath(object.getProperty("actual_number_string"))).getText();
		
		//System.out.println("String is :::"+total_string);
		
		String s1=total_string.trim().substring(8);
	    
		//System.out.println("Actual mail in string format ::::"+s1);
	
		int actual_mail=Integer.valueOf(s1);
		
	    System.out.println("Actual mail in number format:>>:"+actual_mail);
	    
	
	    String s2=total_string.trim().substring(2,4);
	    int div=Integer.valueOf(s2);
	    //System.out.println("Div value is:::"+div);
	    for_count_loop=actual_mail/div;
		

	    int TotalStarredMail_count= 0;
	    
	    for(int d=1;d<=for_count_loop+1;d++)
	    {
	    	WebElement Flag_GmailWebTable = driver.findElement(By.className("UI"));
	    	List<WebElement> Flag_rows_GmailWebTable  = Flag_GmailWebTable.findElements(By.tagName("tr"));
		  
	    	int Flag_rows_Count = Flag_rows_GmailWebTable.size();
		
		
		for (int row=1; row<=Flag_rows_Count; row++) 
		{
			List<WebElement> Flag_name =driver.findElements(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div[7]/div/div[1]/div[2]/div/table/tbody/tr[" + row +"]/td[4]/div[2]/span"));
		 
			List<WebElement> Flag_column_GmailWebTable= driver.findElements(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div/div/div[7]/div/div[1]/div[2]/div/table/tbody/tr[" + row +"]/td[3]/span"));
	   
		  for(int col=0 ;col<Flag_column_GmailWebTable.size();col++)
		  {
			  if(Flag_column_GmailWebTable.get(col).getAttribute("title").equals("Starred"))
			  {	   
				  
				  System.out.println(Flag_name.get(col).getAttribute("name"));
			   
				  TotalStarredMail_count++;	
				  //break;
			  }	   
			  
		  }	
		
		}
		  //Thread.sleep(2000);
		  //loop_count++;
			driver.findElement(By.cssSelector(object.getProperty("right_direction"))).click();
			Thread.sleep(3000);
		}
	    
	    System.out.println("Total STAR mail is :>>:"+TotalStarredMail_count);
	}	
		
		
		
		
		
		
		
		
		
		
		
		
	    
	  /*  for (int row=0; row<row_cont; row++)
	    {
				//for(int j=0;j<col_cont;j++)
				//{
					String final_xpath=start_xpath+row+end_xpath;
					
					//boolean table_data=driver.findElement(By.xpath(final_xpath)).getAttribute("title").equals("Starred");
					
					System.out.println(driver.findElement(By.xpath(final_xpath)).getAttribute("class").equals("Starred"));
		        //}
	    }
	}
		
*/
	
	@DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_009");
	}
	
	
	}
