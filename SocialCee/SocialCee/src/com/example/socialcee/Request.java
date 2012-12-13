package com.example.socialcee;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class Request extends AsyncTask<String, Void, String> {
	
	private String jsobject;

	public Request(String Object) {
		super();
		jsobject = Object;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String doInBackground(String... urls) {
		// TODO Auto-generated method stub
		String response=null;
		for (String url : urls)
			try {
				{
				
					 DefaultHttpClient httpclient = new DefaultHttpClient();
				     HttpPost httppost = new HttpPost(url);
				     
				        
				     List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				     nameValuePairs.add(new BasicNameValuePair("apikey", "96decc6c17394f2c984ac8bc42da9a54"));
				     nameValuePairs.add(new BasicNameValuePair("data", jsobject));
				     
				     try {
						httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     
				    httpclient.execute(httppost);
				     
				    ResponseHandler<String> responseHandler = new BasicResponseHandler();
				    response = httpclient.execute(httppost, responseHandler);
				     
}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return response;
	}
}
