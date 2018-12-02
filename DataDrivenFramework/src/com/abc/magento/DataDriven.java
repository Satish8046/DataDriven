package com.abc.magento;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {

	public static void main(String[] args) throws IOException 
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("D:\\Selenium\\DataDrivenFramework\\src\\com\\abc\\utilities\\data.properties");
		Properties p=new Properties();
		p.load(fis);
		String url =p.getProperty("url");
		String email=p.getProperty("email");
		String pwd=p.getProperty("pwd");
		driver.get(url);
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}
}
