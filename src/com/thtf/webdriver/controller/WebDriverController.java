package com.thtf.webdriver.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.annotation.Resource;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thtf.direct.entity.DirectEntity;
import com.thtf.direct.service.DirectService;
import com.thtf.util.IPUtil;
import com.thtf.util.StringUtil;
import com.thtf.webdriver.entity.IDEntity;
import com.thtf.webdriver.entity.IPEntity;
import com.thtf.webdriver.service.WebDriverService;
import com.thtf.webdriver.util.ElementAction;
import com.thtf.webdriver.util.FFDriverUtil;
import com.thtf.webdriver.util.IEDriverUtil;

@Controller
@RequestMapping("/webDriverController")
public class WebDriverController {
	
	private static final Class<IDEntity> CLASS = IDEntity.class;

	@Resource(name="webDriverService")
	private WebDriverService<IDEntity> idWebDriverService;
	
	@Resource(name="webDriverService")
	private WebDriverService<IPEntity> ipWebDriverService;
	
	@Resource(name="directService")
	private DirectService<DirectEntity> directService;

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	@ResponseBody
	public String send(@RequestParam(value = "text", required = true) final String text) {
		
		System.out.println(text);
		
		FFDriverUtil.findElementById("text1", new ElementAction() {
			@Override
			public void action(WebElement webElement) {
				webElement.clear();
				webElement.sendKeys(text);
			}
		});
		
		FFDriverUtil.findElementById("subText", new ElementAction() {
			@Override
			public void action(WebElement webElement) {
				webElement.click();
			}
		});
		
		return text + "接受成功!";
	}
	
	@RequestMapping(value = "/getIps")
	@ResponseBody
	public List<IPEntity> getIpList() {
		return ipWebDriverService.excuteHql("from IPEntity", null, -1, -1);
	}
	
	@RequestMapping(value = "/openBrowser", method = RequestMethod.GET)
	public void openBrowser(@RequestParam(value = "url", required = true) final String url) {
		System.out.println(url);
		if(url.indexOf("realPlay")==-1){
			//火狐浏览器
			FFDriverUtil.openUrl(url);
		}else{
			//IE浏览器
			IEDriverUtil.openUrl(url);
		}
		
	}
	
	@RequestMapping(value = "/nvgt", method = RequestMethod.GET)
	@ResponseBody
	public void nvgtUrl(@RequestParam(value = "directId", required = true) final String directId) {
		
		//根据指令ID查询fgps
		DirectEntity directEntity = directService.get(DirectEntity.class, directId);
		String fgps = directEntity.getConCode();
		
		String localIp = IPUtil.getIp();
		
		//根据建筑物的ID查询各ID对应关系（IDEntity）
		IDEntity idEntity = idWebDriverService.get(CLASS, fgps);
		//查询IP,判断打开类型
		List<IPEntity> ipList = ipWebDriverService.excuteHql("from IPEntity", null, -1, -1);
		for (IPEntity ipEntity : ipList) {
			String ip = ipEntity.getIp();
			String kind = ipEntity.getKind();
			String type = ipEntity.getType();
			//判断ip是否和本地IP一致
			if(ip.equals(localIp)){
				if("NVGT".equals(type)){
					try {
						Method method = CLASS.getMethod("get"+StringUtil.getFirstUpCase(kind), null);
						String value = (String) method.invoke(idEntity, null);
						
						method = IPUtil.class.getMethod("get"+StringUtil.getFirstUpCase(kind), null);
						String url = (String) method.invoke(new IPUtil(), null);
						url = String.format(url, value+"/"+value,idEntity.getZkuser(),idEntity.getZkpwd());
						System.out.println("动态代理后的URL："+url);
						FFDriverUtil.nvgtUrl(url);
						
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
					
				}else if("CLICK".equals(type)){
					if("AQJK".equals(kind)){
						//工程安全
						new Thread(new Runnable() {
							@Override
							public void run() {
								
								FFDriverUtil.dealHidenElement("document.getElementById(\"text\").value = '" + fgps + "'");
								FFDriverUtil.dealHidenElement("document.getElementById(\"btn\").click()");
								
								/*FFDriverUtil.findElementById("text", new ElementAction() {
									@Override
									public void action(WebElement webElement) {
										//webElement.clear();
										System.out.println(webElement.isDisplayed());
										webElement.sendKeys(fgps);
									}
								});
								FFDriverUtil.findElementById("btn", new ElementAction() {
									@Override
									public void action(WebElement webElement) {
										webElement.click();
									}
								});*/
							}
						}).start();
						
					}else if("SPJK".equals(kind)){
						new Thread(new Runnable() {
							@Override
							public void run() {
								
								IEDriverUtil.dealHidenElement("document.getElementById(\"text\").value = '" + idEntity.getSpjk() + "'");
								IEDriverUtil.dealHidenElement("document.getElementById(\"btn\").click()");
								
								/*IEDriverUtil.findElementById("text", new ElementAction() {
									@Override
									public void action(WebElement webElement) {
										webElement.clear();
										webElement.sendKeys(idEntity.getSpjk());
									}
								});
								IEDriverUtil.findElementById("btn", new ElementAction() {
									@Override
									public void action(WebElement webElement) {
										webElement.click();
									}
								});*/
							}
						}).start();
						
					}else if("SZJK".equals(kind)){
						new Thread(new Runnable() {
							@Override
							public void run() {
								
								FFDriverUtil.dealHidenElement("document.getElementById(\"text\").value = '" + idEntity.getSzcz() + "'");
								FFDriverUtil.dealHidenElement("document.getElementById(\"btn\").click()");
								
								/*FFDriverUtil.findElementById("text", new ElementAction() {
									@Override
									public void action(WebElement webElement) {
										webElement.clear();
										webElement.sendKeys(idEntity.getSzcz());
									}
								});
								FFDriverUtil.findElementById("btn", new ElementAction() {
									@Override
									public void action(WebElement webElement) {
										webElement.click();
									}
								});*/
							}
						}).start();
					}
					
				}
			}
		}
	}
}
