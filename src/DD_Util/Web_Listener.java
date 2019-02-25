package DD_Util;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import DD_Core.Test_Core;

public class Web_Listener extends Test_Core implements ITestListener
{
	@Override
	public void onFinish(ITestContext arg0) {
		
		//Test_Util.zip(System.getProperty("user.dir")+"\\screenshots");
		/*monitoringMail mail=new monitoringMail();
		try {
			mail.sendMail(TestConfig.server,TestConfig.from,TestConfig.to,TestConfig.subject,TestConfig.messageBody,TestConfig.attachmentPath,TestConfig.attachmentName);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//String methodname=result.getName().toString().trim();
		try {
			Test_Util.CaptureScreenshot();
			//Test_Util.zip(System.getProperty("user.dir")+"\\screenshots");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
