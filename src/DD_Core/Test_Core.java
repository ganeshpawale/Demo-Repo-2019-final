package DD_Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.google.gson.annotations.Until;

import DD_Util.ExcelReader;
import DD_Util.TestConfig;
import DD_Util.monitoringMail;

public class Test_Core {
	
	//Intializing Excel file,log_file,Properties file,webdriver etc.


	public static Properties config= new Properties();
	public static Properties object= new Properties();
	public static ExcelReader excel=null;
	public static Logger app_log=Logger.getLogger("devpinoyLogger");
	public static WebDriver driver=null;
	
	@BeforeSuite
	public static void init() throws IOException{ 
	if(driver==null){
       
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\DD_Properties\\Config.Properties");
        config.load(fis);
        app_log.debug("Loding Config File Succesfully");
        
		fis=new FileInputStream("D:\\Java Toutorials\\DDF_Google\\src\\DD_Properties\\Object.Properties");
		object.load(fis);
		app_log.debug("Loading Object File Succesfully");
		
		
		//Loading Excel file
		
		excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\DD_Properties\\excel_sheet_google.xlsx");
		app_log.debug("Loading Excel File");
		
		if(config.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(config.getProperty("browser").equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else if(config.getProperty("browser").equals("firefox"))
		{
			driver= new FirefoxDriver();
			
		}
		
		
		//Implicit wait

		driver.get(config.getProperty("testurl"));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);	
	    
	 }
	}
	
	@AfterSuite
	public void closeBrowser() throws AddressException, MessagingException
	{
		//driver.quit();
		//monitoringMail mail = new monitoringMail();
		//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}
	
	//........isEnabled() Method...............
	public static boolean isElementPresent(By by)
	{
		//System.out.println("Start...");
		boolean exist=driver.findElement(by).isEnabled();
		//System.out.println(name);
		if(exist)
		{
			return true;
			//System.out.println("Element is Present on WebPage");
			
		}
         else
		{
        	 //System.out.println("Element is not present on web page");
			return false;
		}
	}
	
	//........isDisplayed() Method...............
		public static boolean isDisplayedElement(By by)
		{
			//System.out.println("Start...");
			boolean exist=driver.findElement(by).isDisplayed();
			if(exist)
			{
				return true;
				//System.out.println("Element is Present on WebPage");
				
			}
	         else
			{
	        	 //System.out.println("Element is not present on web page");
				return false;
			}
		}
	
	
	
	//Links count
	public static String getLinks(By by)
	{
		
		WebElement element=driver.findElement(by);     
		
		List<WebElement> allLinkElements = element.findElements(By.tagName("a"));
	       
        // Count the total Link list on Web Page 
        int linkListCount = allLinkElements.size();
               
        //Print the total count of links on webpage
        System.out.println("Total Number of link count on webpage = "  + linkListCount);
		return null;    
	}
	
	//Google application click
	public static void google_App_Icon_Click()
	{
        driver.findElement(By.xpath(object.getProperty("flag_google_app"))).click();
	}
	
	//Back command method
	public static void backAction()
	{
		driver.navigate().back();
	} 
	
	//Forward command method
	public static void navigatePage()
	{
		driver.navigate().forward();
	}
	
	//...webdriverwait method
	public static void driverWait(By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
		
	}
	
	//signIn Button existences
	public static void signIn_Button_Present()
	{
		boolean exist=driver.findElement(By.xpath(object.getProperty("flag_Sign_in_btn_rs"))).isDisplayed();
		//System.out.println(exist);
		if(exist)
		{
			System.out.println("Sign In button is Exist on WebPage");
			WebElement element=driver.findElement(By.xpath(object.getProperty("flag_Sign_in_btn_rs")));
			element.click();
		}
		else
		{
			System.out.println("Sign In button is not Exist on WebPage");
		}
	}
	
	//Gmail_Account Login
	public static void account_Login(String mailid,String password)
	{
		  //driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
	      //driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
		  driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
		  driver.findElement(By.xpath(object.getProperty("mail_id1"))).sendKeys(mailid);
	      driver.findElement(By.cssSelector(object.getProperty("next1"))).click();
	      driver.findElement(By.xpath(object.getProperty("pass1"))).sendKeys(password);
	      driver.findElement(By.cssSelector(object.getProperty("submit1"))).click();
	}
	//Gmail_Account Logoff
	public static void account_Logoff()
	{
		//driver.findElement(By.xpath(object.getProperty("menu_icon"))).click();
		driver.findElement(By.xpath(object.getProperty("sign_off1"))).click();
	}
	
	//Gmail image icon 
	public static void image_icon()
	{
		 driver.findElement(By.xpath(object.getProperty("menu_icon"))).click();
	}
	//Checking Google Language
	public static void google_Home()
	{
       driver.navigate().to("https://www.google.com");
	}
	
	        // CheckBox Click Method
			public static boolean IsSelected(By by)
			{
				boolean isSelected = driver.findElement(by).isSelected(); 
				if(isSelected)
				{
					driver.findElement(by).click();
				}
				return isSelected;
				
			}
	
		//Adding table data
			
			 public static int manageUserDataGrid()
			    {
			    	int count=0;
			    	WebElement table = driver.findElement(By.className("UI"));
			    	List<WebElement> rows = table.findElements(By.tagName("tr"));
			    	//for(int j=1;j<=)
			    	List<WebElement> column = table.findElements(By.tagName("td"));
			    	List<String> value = new ArrayList<String>();

			    	System.out.println(rows.size());

			        for (int j=0; j<column.size(); j++)
			        {
			            System.out.println(column.get(j).getText());
			            value.add(column.get(j).getText());
			            count++;
			        }
			        /*if (value.contains("coadminss"))
			        {
			            System.out.println("Value found");
			        }
			        else
			        {
			            System.out.println("Not Found");
			        }*/
			        System.out.println("Count is:::"+count);
					
			        return count;
			    }
			
}
