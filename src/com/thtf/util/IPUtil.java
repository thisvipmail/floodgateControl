package com.thtf.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class IPUtil {
	
	private final static String ZKYX = "http://172.16.2.20/Login.aspx?ReturnUrl=/SvgPage.aspx?Page=Pages/%s.svg&u=%s&p=%s";
	private final static String ZKGJ = "http://172.16.2.20/Login.aspx?ReturnUrl=/SvgPage.aspx?Page=Pages/%s.svg&u=%s&p=%s";
	
	public static String getIp() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				// System.out.println(netInterface.getName());
				if (netInterface.getName().indexOf("eth") == -1) {
					continue;
				}
				Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						System.out.println("本机的IP = " + ip.getHostAddress());
						return ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public String getZkyx(){
		return ZKYX;
	}
	
	public String getZkgj(){
		return ZKGJ;
	}
}
