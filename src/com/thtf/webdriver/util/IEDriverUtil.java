package com.thtf.webdriver.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverUtil {

	private static WebDriver driver = null;
	
	public static void openUrl(String url) {
		
        System.setProperty("webdriver.ie.driver", "E:/work/IEDriverServer/IEDriverServerX32.exe");

		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability("ignoreProtectedModeSettings", true);

		// 定义驱动对象为 InternetExplorerDriver 对象
		if(driver == null){
			driver = new InternetExplorerDriver(capability);
		}else{
			try {
				driver.getCurrentUrl();
			} catch (Exception e) {
			}finally{
				driver = new InternetExplorerDriver(capability);
			}
		}

		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			driver = new InternetExplorerDriver(capability);
		}
		
        //浏览器窗口变大
        driver.manage().window().maximize();

        driver.get(url);
        
	}
	public static void nvgtUrl(String url) {
		
		System.setProperty("webdriver.ie.driver", "E:/work/IEDriverServer/IEDriverServerX32.exe");

		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability("ignoreProtectedModeSettings", true);

		// 定义驱动对象为 FirefoxDriver 对象
		if(driver == null){
			driver = new InternetExplorerDriver(capability);
		}else{
			try {
				driver.getCurrentUrl();
			} catch (Exception e) {
			}finally{
				driver = new InternetExplorerDriver(capability);
			}
		}
		
		try {
			driver.getCurrentUrl();
		} catch (Exception e) {
			driver = new InternetExplorerDriver(capability);
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
