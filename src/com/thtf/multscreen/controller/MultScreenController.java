package com.thtf.multscreen.controller;

import javax.annotation.Resource;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.thtf.multscreen.entity.FloodPumpCam;
import com.thtf.multscreen.service.MultScreenService;
import com.thtf.websocket.ThtfWebSocketHandler;

@Controller
@RequestMapping("/multScreenController")
public class MultScreenController {

	@Resource(name="multScreenService")
	private MultScreenService service;
	
	/**
	 * 根据映射跳转到指定的页面
	 */
	@RequestMapping(value = "/setFloodPumpID", method = RequestMethod.GET)
	public String setFloodPumpID(@RequestParam(value = "floodPumpId", required = true)String floodPumpId) {
		
		FloodPumpCam fpc = service.getFloodPumpID(floodPumpId);
		System.out.println(fpc.getCamID());
		System.out.println(fpc.getFloodPumpId());
		System.out.println(fpc.getPath());
		try {
			this.goToCamera(fpc.getCamID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ajax-add-page.jsp?floodPumpId=" + fpc.getFloodPumpId();
	}
	
	private void goToCamera(String camID) throws Exception{
		String endpoint = "http://192.168.0.100:10000/gatePump/gatePumpservice";   
        Service service = new Service();   
        Call call = (Call)service.createCall();   
        call.setTargetEndpointAddress(endpoint);      

        call.setOperationName(new QName(   
                "urn:gatePump", "setGatePumpID"));   
        call.addParameter( "id",null,ParameterMode.IN);  
        call.setReturnClass(Integer.class);   
        Integer temp = (Integer)call.invoke(new Object[]{camID});   
        System.out.println("result: " + temp);  
	}
}
