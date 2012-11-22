package com.example.socialcee;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

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
	public String getJson() 
	{
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		String response = new String();
		try 
		{
			response = httpClient.execute(httpGet, responseHandler);
		} 
		catch (ClientProtocolException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return response;
	}
		
    }

