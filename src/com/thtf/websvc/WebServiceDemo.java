package com.thtf.websvc;

/**
 * 不需要借口实现的axis2 webservice 服务端
 * @author WHOAMI
 *
 */
public class WebServiceDemo{

	public String hello(String name, Integer age) {
		return name + age;
	}


}
