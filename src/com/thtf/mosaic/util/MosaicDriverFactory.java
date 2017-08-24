package com.thtf.mosaic.util;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.apache.axis2.AxisFault;

import com.client.MswebserviceStub;

public class MosaicDriverFactory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 345344341L;

	private static MswebserviceStub stub=null;
	private static String  wsdlPath="http://172.16.2.18:9900/";
	private static String userId = "0";

	public MosaicDriverFactory() {
		init();
	}
	public MosaicDriverFactory(String wsdlPath) {
		init(wsdlPath);
	}

	/**
	 * @Title: init
	 * @Description: 初始化
	 * @param
	 * @return void
	 * @throws
	 */
	public void init() {
		if(stub==null){
			try {
				stub = new MswebserviceStub(wsdlPath);
			} catch (AxisFault e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @Title: init
	 * @Description: 初始化
	 * @param @param wsdlPath
	 * @return void
	 * @throws
	 */
	public void init(String wsdlPath) {
		if(stub==null){
			try {
				stub = new MswebserviceStub(wsdlPath);
			} catch (AxisFault e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Title: connectOpen
	 * @Description: 连接方法
	 * @param @param dbName
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String connectOpen(String mdbName) {
		try {
			MswebserviceStub.WSConnectOpen open = new MswebserviceStub.WSConnectOpen();
			MswebserviceStub.WSConnectOpenResponse req = null;
			MswebserviceStub.UserInfo userInfo = new MswebserviceStub.UserInfo();
			userInfo.setMUserID(userId);
			userInfo.setMUserName("");
			userInfo.setMUserPass("");
			userInfo.setMdbName(mdbName);
			userInfo.setMdbInstance("master");
			userInfo.setMIP("");
			userInfo.setComText("");
			open.setUserInfo(userInfo);
			req = stub.wSConnectOpen(open);
			userId = req.getId();
			if (userId == null || userId.trim().length() < 1) {
				System.out.println("mosaic连接失败，userId是空");
				return userId;
			} else {
				System.out.println("mosaic连接成功,  " + userId);
				return userId;
			}
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;
	}

	/**
	 * @Title: executeSql
	 * @Description: 执行sql语句获得数据
	 * @param @param sql
	 * @param @return
	 * @return DataResult
	 * @throws
	 */
	public String executeSql(String sql) {
		try {
			StringBuffer stringBuffer = new StringBuffer();
			MswebserviceStub.WSQueryExecute exe = new MswebserviceStub.WSQueryExecute();
			MswebserviceStub.DataResult req = null;
			MswebserviceStub.UserInfo userInfo = new MswebserviceStub.UserInfo();
			userInfo.setMUserID(userId);
			userInfo.setMUserName("");
			userInfo.setMUserPass("");
			userInfo.setMdbName("scada");
			userInfo.setMdbInstance("master");
			userInfo.setMIP("");
			userInfo.setComText(sql);
			exe.setUserInfo(userInfo);
			req = stub.wSQueryExecute(exe);
			System.out.println(req.getData());
			while(req.getData()!=null&req.getData().length()>0){
                if (req.getErrMsg().trim().length()>0)
                {
	               	 System.out.println("返回数据有错误");
	               	 return "0";//获取数据失败
                }
                stringBuffer.append(req.getData()).append(";");
                MswebserviceStub.WSQueryNext wsnext = new MswebserviceStub.WSQueryNext();
                wsnext.setUserInfo(userInfo);
                req = stub.wSQueryNext(wsnext);
			}
			//stringBuffer.delete(stringBuffer.length()-1, stringBuffer.length());
			return stringBuffer.toString();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
	}

	/**
	 * @Title: disconnect
	 * @Description: 断开连接
	 * @param
	 * @return void
	 * @throws
	 */
	public Integer disconnect() {
		if (userId == "0") {
			return 0;
		}
		try {
			MswebserviceStub.WSConnectClose exe = new MswebserviceStub.WSConnectClose();
			MswebserviceStub.WSConnectCloseResponse req = null;
			MswebserviceStub.UserInfo userInfo = new MswebserviceStub.UserInfo();
			userInfo.setMUserID(userId);
			userInfo.setMUserName("");
			userInfo.setMUserPass("");
			userInfo.setMdbName("scada");
			userInfo.setMdbInstance("master");
			userInfo.setMIP("");
			userInfo.setComText("");
			exe.setUserInfo(userInfo);
			req = stub.wSConnectClose(exe);
			return req.getCloseFlag();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @Title: initConDataDis
	 * @Description: 初始化 建立连接 返回数据 销毁链接
	 * @param @param wsdlPath 路径
	 * @param @param dbName 数据库名称
	 * @param @param sql sql语句
	 * @param @return
	 * @return DataResult
	 * @throws
	 */
	public Map<String,String>  initConDataDis(String wsdlPath, String mdbName, String sql) {
		Map<String,String> dataMap = new HashMap<String,String> ();
		// 1、初始化
		try {
			if(stub==null){
				// 2、建立webservice连接
				if (wsdlPath != null) {
						stub = new MswebserviceStub(wsdlPath);
				} else {
					stub = new MswebserviceStub(this.getWsdlPath());
				}
				
			}
			//打开连接
			MswebserviceStub.WSConnectOpen open = new MswebserviceStub.WSConnectOpen();
			MswebserviceStub.WSConnectOpenResponse req = null;
			MswebserviceStub.UserInfo userInfo = new MswebserviceStub.UserInfo();
			userInfo.setMUserID(userId);
			userInfo.setMUserName("");
			userInfo.setMUserPass("");
			userInfo.setMdbName(mdbName);
			userInfo.setMdbInstance("master");
			userInfo.setMIP("");
			userInfo.setComText("");
			open.setUserInfo(userInfo);
			req = stub.wSConnectOpen(open);
			userId = req.getId();
			if (userId == null || userId.trim().length() < 1 || userId.equals("0")) {
				System.out.println("mosaic连接失败，userId是空");
				dataMap.put("connFlag", "0");
				return dataMap;
			}
			System.out.println("mosaic连接成功,  " + userId);
			dataMap.put("connFlag", "1");
			//4、执行数据查询
			MswebserviceStub.WSQueryExecute exe = new MswebserviceStub.WSQueryExecute();
			MswebserviceStub.DataResult dataR = null;
			userInfo.setMUserID(userId);
			userInfo.setComText(sql);
			exe.setUserInfo(userInfo);
			dataR = stub.wSQueryExecute(exe);
			StringBuffer stringBuffer = new StringBuffer();
			while(dataR.getData()!=null&dataR.getData().trim().length()>0){
			         if (dataR.getErrMsg().trim().length()>0)
			         {
			        	 System.out.println("返回数据有错误");
			        	 dataMap.put("dataRtFlag", "0");
			        	 return dataMap;//获取数据失败
			         }
			         dataMap.put("dataRtFlag", "1");
			         stringBuffer.append(dataR.getData()).append(";");
			         MswebserviceStub.WSQueryNext wsnext = new MswebserviceStub.WSQueryNext();
			         wsnext.setUserInfo(userInfo);
			         dataR = stub.wSQueryNext(wsnext);
			}
			stringBuffer.delete(stringBuffer.length()-1, stringBuffer.length());
			dataMap.put("dataResult", stringBuffer.toString());
			//5、断开连接
			MswebserviceStub.WSConnectClose close = new MswebserviceStub.WSConnectClose();
			MswebserviceStub.WSConnectCloseResponse closeReq = null;
			close.setUserInfo(userInfo);
			closeReq = stub.wSConnectClose(close);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return dataMap;
	}

	public static String getUserId() {
		return userId;
	}

	public static void setUserId(String userId) {
		MosaicDriverFactory.userId = userId;
	}
	public static MswebserviceStub getStub() {
		return stub;
	}
	public static void setStub(MswebserviceStub stub) {
		MosaicDriverFactory.stub = stub;
	}
	public static String getWsdlPath() {
		return wsdlPath;
	}
	public static void setWsdlPath(String wsdlPath) {
		MosaicDriverFactory.wsdlPath = wsdlPath;
	}

	public int sendControl(String attr, double value) throws RemoteException{
		
		MswebserviceStub.UserInfo userInfo = new MswebserviceStub.UserInfo();
		userInfo.setMdbName("scada");
		userInfo.setMdbInstance("master");
		userInfo.setComText("");
		userInfo.setMIP("");
		userInfo.setMUserName("");
		userInfo.setMUserPass("");
		userInfo.setMUserID(userId);
		
		// Write point
		MswebserviceStub.WSSendControl writeReq = new MswebserviceStub.WSSendControl();
		MswebserviceStub.WSSendControlResponse writeResp = null;
		writeReq.setUserInfo(userInfo);
		writeReq.setPointAltId(attr);
		writeReq.setDblValue(value);
		writeResp = stub.wSSendControl(writeReq);
		return writeResp.getRet();
	}
	
	

}
