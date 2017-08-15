package com.thtf.websvc.client;

import java.io.IOException;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class RPCClient {

	public static String address2 = "http://localhost:8080/floodgateControl/services/webServiceDemo?wsdl";

	public static void main(String[] args) throws IOException {

		testWebDemo();

	}

	@SuppressWarnings("rawtypes")
	public static Object[] invoke(String method, Object[] params, Class[] classes) throws AxisFault {
		// 使用RPC方式调用WebService
		RPCServiceClient client = new RPCServiceClient();
		Options option = client.getOptions();

		// 指定调用的URL
		EndpointReference reference = new EndpointReference(address2);
		option.setTo(reference);

		/*
		 * 设置要调用的方法 http://ws.apache.org/axis2 为默认的（无package的情况）命名空间， 如果有包名，则为
		 * http://axis2.webservice.elgin.com ,包名倒过来即可 method为方法名称
		 * 
		 */
		QName qname = new QName("http://websvc.thtf.com", method);

		// 调用远程方法,并指定方法参数以及返回值类型
		Object[] result = client.invokeBlocking(qname, params, classes);

		return result;

	}

	public static void testWebDemo() throws AxisFault {
		Object[] result = invoke("hello", new Object[] { "liuning", 12 }, new Class[] { String.class, Integer.class });
		System.out.println(result[0]);
	}
}