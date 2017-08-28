package com.thtf.websvc.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import com.google.gson.Gson;
import com.thtf.direct.entity.DirectEntity;

public class RPCClientDirect {

	public static String address = "http://localhost:8080/floodgateControl/services/webServiceDirect?wsdl";

	public static void main(String[] args) throws IOException {

		testWebDemo();

	}

	@SuppressWarnings("rawtypes")
	public static void invoke(String method, Object[] params, Class[] classes) throws AxisFault {
		// 使用RPC方式调用WebService
		RPCServiceClient client = new RPCServiceClient();
		Options option = client.getOptions();

		// 指定调用的URL
		EndpointReference reference = new EndpointReference(address);
		option.setTo(reference);
		option.setProperty(Constants.Configuration.MESSAGE_TYPE,HTTPConstants.MEDIA_TYPE_APPLICATION_ECHO_XML);
		option.setProperty(Constants.Configuration.DISABLE_SOAP_ACTION,Boolean.TRUE);
		option.setTransportInProtocol(Constants.TRANSPORT_HTTP);  
		option.setProperty(HTTPConstants.CHUNKED, "false");//设置不受限制.  

		/*
		 * 设置要调用的方法 http://ws.apache.org/axis2 为默认的（无package的情况）命名空间， 如果有包名，则为
		 * http://axis2.webservice.elgin.com ,包名倒过来即可 method为方法名称
		 * 
		 */
		QName qname = new QName("http://websvc.thtf.com", method);

		// 调用远程方法,并指定方法参数以及返回值类型
		//client.invokeBlocking(qname, params, classes);

		client.invokeRobust(qname, params);
	}

	public static void testWebDemo() throws AxisFault {
		ArrayList<DirectEntity> list = new ArrayList<DirectEntity>();
		DirectEntity de = new DirectEntity();
		de.setAftLevel(123);
		de.setBefLevel(234);
		de.setConCode("KRJD010012");
		de.setStaTime(new Date());
		de.setEndTime(new Date());
		de.setConModel("01");
		list.add(de);
		
		Gson gson = new Gson();
		String str = gson.toJson(list);
		
		invoke("receive", new Object[] { str }, new Class[] { String.class });
	}
}