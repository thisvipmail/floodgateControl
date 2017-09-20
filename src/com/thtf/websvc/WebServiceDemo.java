package com.thtf.websvc;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.thtf.websocket.ThtfWebSocketHandler;

/**
 * 不需要借口实现的axis2 webservice 服务端
 * @author WHOAMI
 *
 */
@Component(value="webServiceDemo")
public class WebServiceDemo{

	@Resource
	ThtfWebSocketHandler handler;
	
	public String hello(String name, Integer age) {
		System.out.println("handler:"+handler);
		try {
			handler.broadcast("zl", "测试指令");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name + age;
	}


}
