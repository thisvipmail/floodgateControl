package com.thtf.webdriver.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FFDriverUtil {

	private static WebDriver driver = null;
	
	public static void openUrl(String url) {
		
		System.setProperty("webdriver.firefox.bin", "D:/Mozilla Firefox/firefox.exe"); 
		System.setProperty("webdriver.gecko.driver", "E:/work/ffDriverServer/geckodriver-X64.exe"); 

		// 定义驱动对象为 FirefoxDriver 对象
		if(driver == null){
			driver = new FirefoxDriver();
		}else{
			try {
				driver.getCurrentUrl();
			} catch (Exception e) {
			}finally{
				driver = new FirefoxDriver();
			}
		}

        //浏览器窗口变大
        driver.manage().window().maximize();

        //重新打开浏览窗口
        driver.get(url);
	}
	public static void nvgtUrl(String url) {
		
		System.setProperty("webdriver.firefox.bin", "D:/Mozilla Firefox/firefox.exe"); 
		System.setProperty("webdriver.gecko.driver", "E:/work/ffDriverServer/geckodriver-X64.exe"); 

		// 定义驱动对象为 FirefoxDriver 对象
		if(driver == null){
			driver = new FirefoxDriver();
		}else{
			try {
				driver.getCurrentUrl();
			} catch (Exception e) {
			}finally{
				driver = new FirefoxDriver();
			}
		}
		
        //浏览器窗口变大
        driver.manage().window().maximize();

        //浏览窗口重定位
        driver.navigate().to(url);
	}
	
	public static void findElementById(String id,ElementAction elementAction){
		WebElement webElement = driver.findElement(By.id(id));
		elementAction.action(webElement);
	}
	
	public static void dealHidenElement(String js){
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;    
		javascriptExecutor.executeScript(js);
	}
}
