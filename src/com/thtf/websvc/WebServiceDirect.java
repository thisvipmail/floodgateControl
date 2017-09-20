package com.thtf.websvc;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.thtf.websocket.ThtfWebSocketHandler;

/**
 * 不需要接口实现的axis2 webservice 指令服务端
 * @author WHOAMI
 *
 */
@Component(value="webServiceDirect")
public class WebServiceDirect implements IWebServiceDirect{
	
	@Resource
	ThtfWebSocketHandler handler;

	/**
	 * 从webservice客户端接受指令列表，然后通过websocket的方式广播指令
	 * @param directList
	 */
	public void receive(String direct) {
		System.out.println(direct);
		try {
			handler.broadcast("zl", direct);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ThtfWebSocketHandler getHandler() {
		return handler;
	}

	public void setHandler(ThtfWebSocketHandler handler) {
		this.handler = handler;
	}

}
