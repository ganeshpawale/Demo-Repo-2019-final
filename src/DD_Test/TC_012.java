/*TC_012   :To verify the total no. of emails marked with STAR
 * Author  :Ganesh D Pawale
 * Date    :4-June-2017
 * Version :Version: Mars.2 Release (4.5.2)
   Build id:20160218-0600 
 */ 

    package DD_Test;
    import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

	public class TC_012 extends Test_Core{


	@BeforeTest
		
		public void isSkip()
		{
			if(!Test_Util.isExecutable("TC_012"))
			{
				throw new SkipException("Skiping the test case as run mode set to NO");
			}
		}
	
	@Test(dataProvider="getData")
	public void user_Login_Gmail(String mailid,String passward,String username) throws InterruptedException 
	{
		System.out.println("*********************TC_012 Execution Start*********************");
		
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
	  
	    for_count_loop=actual_mail/div;
		System.out.println("for_count_loop value is integer:>>:"+for_count_loop);
		
		int unreadCount = 0,readCount = 0;;
		for(int d=1;d<=for_count_loop+1;d++)
	    {
	    	WebElement Flag_GmailWebTable = driver.findElement(By.className("UI"));
	    	List<WebElement> Flag_rows_GmailWebTable  = Flag_GmailWebTable.findElements(By.tagName("tr"));
		  
	    	int Flag_rows_Count = Flag_rows_GmailWebTable.size();
	    	
	    	for (int row = 0; row < Flag_rows_Count; row++) {
				
				try{
					String fontWeight = Flag_rows_GmailWebTable.get(row).findElement(By.className("yP")).getCssValue("fontWeight");
					if(fontWeight.equals("normal"))
					{
						readCount++;
						System.out.println("Try excecute");
					}
				}
				catch(Throwable t)
				{
					String fontWeight = Flag_rows_GmailWebTable.get(row).findElement(By.className("zF")).getCssValue("fontWeight");
					if(fontWeight.equals("bold"))
					{
						unreadCount++;
						System.out.println("Catch excecute");
					}
					
				}
				
				System.out.println("Inner for execute...........");
			}
	    	
	    	
	    	    Thread.sleep(2000);
				driver.findElement(By.cssSelector(object.getProperty("right_direction"))).click();
			    Thread.sleep(3000);
				driver.navigate().refresh();
				System.out.println("Outter for execute");
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*try{
			
			Thread.sleep(2000);
			
			WebElement table = driver.findElement(By.className("UI"));
			
			int mailCount = 0;
			
			String TotalMailText = driver.findElement(By.className("Dj")).getText();
			
			String TotalMails[] = TotalMailText.split(" ");
			
			int dividend = Integer.parseInt(TotalMails[2].replaceAll(",",""));
			
			int diviser = Integer.parseInt(TotalMails[0].toString().substring(2, TotalMails[0].length()));
			
			int count = dividend/diviser;

			int unreadCount=0;
			
			int readCount=0;
			//System.out.println(count);
			
			if (diviser == dividend) {
				
				count--;
				
			}
			for (int i = count; i>=0; i--) {
				
				List<WebElement> table_rows = table.findElements(By.tagName("tr"));
				
				int table_rows_count = table_rows.size();

				for (int row = 0; row < table_rows_count; row++) {
					
					try{
						
						String fontWeight = table_rows.get(row).findElement(By.className("zF")).getCssValue("fontWeight");
						if(fontWeight.equals("bold"))
						{
							unreadCount++;
						}
						
					}
					catch(Throwable t)
					{
						String fontWeight = table_rows.get(row).findElement(By.className("yP")).getCssValue("fontWeight");
						if(fontWeight.equals("normal"))
						{
							readCount++;
						}
					}
					
				}
				Thread.sleep(5000);
				driver.findElement(By.cssSelector(".amJ.T-I-J3")).click();
				
				mailCount = table_rows.size()+mailCount;
				
				Thread.sleep(9000);
			}
				System.out.println("Total no of read Emails are: "+readCount);		
				
				System.out.println("Total no of Unread Emails are: "+unreadCount);				

				Thread.sleep(1000);
				
				
		}
		catch(Throwable t)
		{
			//TestUtil.CaptureScreenshot();
			Assert.assertTrue(false,t.getMessage());
		}*/
}
		
	
	@DataProvider
	public static Object[][] getData()
	{
		return Test_Util.getData("TC_009");
	}
	
	
	}
