package com.thtf.websvc;

public interface IWebServiceDirect{
	
	/**
	 * 从webservice客户端接受指令列表，然后通过websocket的方式广播指令
	 * @param directList
	 */
	public void receive(String direct);

}
