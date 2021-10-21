package com.store.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadandWriteExcel {
	
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\sonal\\Desktop\\Excels\\ReadData.xlsx");
	
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Special%3ASearch&returntoquery=search%3D%26go%3DGo");
	}

	
	@Test
	public void createaccountTest()
	
	{
		// Create column in your sheet
		reader.addColumn("Sheet1", "Status");
		
		// Count the number of rows in the sheet which has data
	int rowcount=	reader.getRowCount("Sheet1");
	
	for(int i=2;i<=rowcount;i++)
	{
	String uname= reader.getCellData("Sheet1", "Username", i);
	String pwd = reader.getCellData("Sheet1", "password", i);
    String rpwd= reader.getCellData("Sheet1", "retypePassword", i);
    String em = reader.getCellData("Sheet1", "email", i);
    
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[1]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[1]"))
    .sendKeys(uname);
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[2]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[2]"))
    .sendKeys(pwd);
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[3]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[3]"))
    .sendKeys(rpwd);
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[4]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[4]"))
    .sendKeys(em);
	
    reader.setCellData("Sheet1", "Status", i, "Pass");
	
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
