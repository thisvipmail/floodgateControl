package com.thtf.mosaic;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.client.MswebserviceStub;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Java");
		
		try {
			MswebserviceStub stub = new MswebserviceStub("http://172.16.2.18:9900/");
			
			MswebserviceStub.WSConnectOpen openReq= new MswebserviceStub.WSConnectOpen();
			MswebserviceStub.WSConnectOpenResponse openResp = null;
			
			MswebserviceStub.UserInfo userInfo = new MswebserviceStub.UserInfo();
			userInfo.setMdbName("scada");
			userInfo.setMdbInstance("master");
			userInfo.setComText("");
			userInfo.setMIP("");
			userInfo.setMUserID("");
			userInfo.setMUserName("");
			userInfo.setMUserPass("");
			
			// Open
			openReq.setUserInfo(userInfo);
			openResp = stub.wSConnectOpen(openReq);
			System.out.println(openResp.getId());
			// Save UserID
			userInfo.setMUserID(openResp.getId());
			
			// Write point
			MswebserviceStub.WSSendControl writeReq = new MswebserviceStub.WSSendControl();
			MswebserviceStub.WSSendControlResponse writeResp = null;
			writeReq.setUserInfo(userInfo);
			writeReq.setPointAltId("JD_BXCN_MX_C_ZHKD");
			writeReq.setDblValue(123);
			writeResp = stub.wSSendControl(writeReq);
			System.out.println(writeResp.getRet());
			
			// Close
			MswebserviceStub.WSConnectClose closeReq = new MswebserviceStub.WSConnectClose();
			closeReq.setUserInfo(userInfo);
			stub.wSConnectClose(closeReq);
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
