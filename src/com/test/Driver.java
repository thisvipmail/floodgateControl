package com.test;

import com.thtf.webdriver.util.FFDriverUtil;

public class Driver {

	public static void main(String[] args) {
		String url = "http://172.16.2.20/Login.aspx?ReturnUrl=/SvgPage.aspx?Page=Pages/Schem_Global1_423827852/Schem_Global1_423827852.svg&u=b2233b50269194b2ba5b585d6a046134c0&p=94486ddc5859f9fa0182d61d";
		FFDriverUtil.nvgtUrl(url);
	}

}
