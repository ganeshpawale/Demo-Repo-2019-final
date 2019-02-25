package Rough;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import DD_Core.Test_Core;

public class Demo extends Test_Core{

	public static void main(String[] args) {
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
	
		
		boolean flag_Sign_in_btn, flag_google_textbox, flag_google_Search_btn, flag_google_lucky_btn;
		int no=5;
		if(no>0)
		{
		flag_Sign_in_btn=isElementPresent(By.xpath("//*[@id='gb_70']"));
		
		flag_google_textbox=isElementPresent(By.xpath("//*[@id='sb_ifc0']"));
		
		flag_google_Search_btn=isElementPresent(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]"));
		
		flag_google_lucky_btn=isElementPresent(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[2]"));
		
		
		if(flag_Sign_in_btn==true)
		{
			System.out.println("SignIn Button Present on WebPage");
			
		}
		else if(flag_google_textbox==true)
		{
			System.out.println("Google TextBox Present on WebPage");
		}
		else if(flag_google_Search_btn==true)
		{
			System.out.println("Google Button Present on WebPage");
		}
		else if(flag_google_lucky_btn==true)
		{
			System.out.println("I'm Feeling Lucky Button on WebPage");
		}
		}
		
		
		
		
		
		/*
		if(flag_Sign_in_btn && flag_google_textbox && flag_google_Search_btn && flag_google_lucky_btn)
		{
			System.out.println("All Element is Present on Google Page");
		}
	  
		else
		{
			System.out.println("All Element is not Present on Google Page");
		}
		
	*/
		
	}

}
