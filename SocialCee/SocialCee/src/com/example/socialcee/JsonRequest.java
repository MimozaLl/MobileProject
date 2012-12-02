package com.example.socialcee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class JsonRequest {

	private String url;
	
	public JsonRequest() 
	{
		// TODO Auto-generated constructor stub
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String URL)
	{
		url = URL;
	}
	public String getJson(String temp) 
	{
   		String response = new String();
   		HttpClient httpclient = new DefaultHttpClient();
	   	HttpPost httppost = new HttpPost("https://api.socialcee.com/services/AccountsHandler.ashx");
	   	try 
	   	{
	   	   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	       nameValuePairs.add(new BasicNameValuePair("apikey", "96decc6c17394f2c984ac8bc42da9a54"));
	       httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	   	   httpclient.execute(httppost);
	   	   ResponseHandler<String> responseHandler = new BasicResponseHandler();
	   	   response = httpclient.execute(httppost, responseHandler);
	     } catch (ClientProtocolException e) {
	         // TODO Auto-generated catch block
	     } catch (IOException e) {
	         // TODO Auto-generated catch block
	     }
	   	 return response;
	}
		
    }

