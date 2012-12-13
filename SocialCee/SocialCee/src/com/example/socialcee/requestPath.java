package com.example.socialcee;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;

public class requestPath extends AsyncTask<String, Void, String>{
			
	private String jsobject;
	
	public requestPath(String Object) {
		super();
		jsobject=Object;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String doInBackground(String... urls) {
		// TODO Auto-generated method stub
		
		String response=null;
		for (String url : urls) {
		
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
		     
		     try {
		    	 
				httpclient.execute(httppost);
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     ResponseHandler<String> responseHandler = new BasicResponseHandler();
		     
		    try {
		    	
				 response = httpclient.execute(httppost, responseHandler);
				 
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
		}
		     		
		return response;
	}

	/*@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}*/

}
