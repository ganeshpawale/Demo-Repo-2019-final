package DD_Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import DD_Core.Test_Core;

public class Test_Util extends Test_Core {

	public static boolean isExecutable(String TCID)
	{
		String sheetName=("Test_Case");
		
		for(int rowNum=2;rowNum<=excel.getRowCount(sheetName);rowNum++)
		{
			if(excel.getCellData(sheetName,"TCID",rowNum).equals(TCID))
			{
				if(excel.getCellData(sheetName,"RUNMODE", rowNum).equals("Y"))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		}
		
		return false;
	}
	
	//Reading Data From Excel file
	
	public static Object[][] getData(String sheetName)
	{
		int rows= excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		
		Object[][] data= new Object[rows-1][cols];
		
		for(int rowNum =2;rowNum<=rows;rowNum++)
		{
			for(int colNum=0;colNum <cols;colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName,colNum,rowNum);
			}
		}
		/*Hashtable<String,String>table=null;
		for (int rowNum =2; rowNum <=rows; rowNum++) {
			
			table=new Hashtable<String,String>();
			for (int colNum = 0; colNum <cols; colNum++) 
			{
				table.put(excel.getCellData(sheetName,colNum,1),excel.getCellData(sheetName, colNum, rowNum));
				
				//data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				data[rowNum-2][colNum]=table;
			}
		}*/
		return data;
	}
	


	//CaptureScreenshot 
	
	public static void CaptureScreenshot() throws IOException{
		
		  Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); //3
		  int year = cal.get(Calendar.YEAR); //2014
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try
		  {
			  String mailscreenshotpath = System.getProperty("user.dir")+"\\screenshots\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
			  System.out.println("ScreenShot Capcher");
			  FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		  }catch(IOException e){
			  
			  e.printStackTrace();
		  }
	}
	
	 
	     //make zip of reports
	  		public static void zip(String filepath){
	  		 	try
	  		 	{
	  		 		File inFolder=new File(filepath);
	  		 		File outFolder=new File("Reports.zip");
	  		 		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outFolder)));
	  		 		BufferedInputStream in = null;
	  		 		byte[] data  = new byte[1000];
	  		 		String files[] = inFolder.list();
	  		 		for (int i=0; i<files.length; i++)
	  		 		{
	  		 			in = new BufferedInputStream(new FileInputStream
	  		 			(inFolder.getPath() + "/" + files[i]), 1000);  
	  		 			out.putNextEntry(new ZipEntry(files[i])); 
	  		 			int count;
	  		 			while((count = in.read(data,0,1000)) != -1)
	  		 			{
	  		 				out.write(data, 0, count);
	  		 			}
	  		 			out.closeEntry();
	  		 			  }
	  		
	  		 	
	  		 	out.flush();
	  			  out.close();
	  			 	
	  		}
	  		  catch(Exception e)
	  		  {
	  			  e.printStackTrace();
	  		  } 

	  	}
	   
	
	}

