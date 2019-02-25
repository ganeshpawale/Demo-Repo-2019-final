


package DD_Test;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DD_Core.Test_Core;
import DD_Util.Test_Util;

public class TC_013 extends Test_Core{


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
		System.out.println("*********************TC_013 Execution Start*********************");
		
	}
	
	
	
}