package com.store.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WriteExcel {
	

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
	public void WriteToExcel()
	{
		reader.addSheet("WikiTest");
		if(reader.isSheetExist("WikiTest"))
		{
		reader.addColumn("WikiTest", "Link");
		reader.addColumn("WikiTest", "PageTitle");
		}
		
		String link1=driver.findElement(By.linkText("Main page")).getText();
		
		reader.setCellData("WikiTest", "Link", 2, link1);
		
		driver.findElement(By.linkText("Main page")).click();
		
		String title1= driver.getTitle();
		
		reader.setCellData("WikiTest", "PageTitle", 2, title1);
		
		String link2 = driver.findElement(By.linkText("Contents")).getText();
		reader.setCellData("WikiTest", "Link", 3, link2);
		driver.findElement(By.linkText("Contents")).click();
        String title2= driver.getTitle();
		
		reader.setCellData("WikiTest", "PageTitle", 3, title2);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
