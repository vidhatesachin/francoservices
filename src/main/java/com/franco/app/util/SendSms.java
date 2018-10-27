package com.franco.app.util;

import java.net.*;

public class SendSms {
	
	public static void send(String message, String mobileNum) {
	try {
	String apikey = "tCMnt67OeUS1FhCX4wZNIQ";
	String senderid = "TESTIN";
	String channel = "";
	String DCS = "0";
	String flashsms = "0";
	String mobile = "9168456633";
	String route = "";
	if(mobileNum!=null) {
		mobile = mobileNum;
	}
	//https://www.smsgatewayhub.com/api/mt/SendSMS?APIKey=YOURAPIKEY&senderid=YOURSENDERID&channel=2&DCS=0&flashsms=0&number=91XXXXX&text=hello%20this%20is%20testing%20message&route=
	 
	 
	String requestUrl = "https://www.smsgatewayhub.com/api/mt/SendSMS?" +
	"APIKey=" + URLEncoder.encode(apikey, "UTF-8") +
	"&senderid=" + URLEncoder.encode(senderid, "UTF-8") +
	"&channel=" + URLEncoder.encode(channel, "UTF-8") +
	"&DCS=" + URLEncoder.encode(DCS, "UTF-8") +
	"&flashsms=" + URLEncoder.encode(flashsms, "UTF-8") +
	"&number=" + URLEncoder.encode(mobile, "UTF-8") +
	"&text=" + URLEncoder.encode(message, "UTF-8") +
	"&route=" + URLEncoder.encode(route, "UTF-8");
	 
	 
	 
	URL url = new URL(requestUrl);
	HttpURLConnection uc = (HttpURLConnection)url.openConnection();
	 
	System.out.println(uc.getResponseMessage());
	 
	uc.disconnect();
	 
	} catch(Exception ex) {
	System.out.println(ex.getMessage());
	 
	}
}

}