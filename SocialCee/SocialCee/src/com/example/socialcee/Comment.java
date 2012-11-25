package com.example.socialcee;

import org.json.JSONObject;

import android.text.format.Time;

public class Comment{
	
	private long PostId;
	private String Message;
	private JSONObject From = new JSONObject();
	private Time TimeCreated;
	
	public void setPostId(long id)
	{
		PostId = id;
	}
	public void setMessage(String message)
	{
		Message = message;
	}
	public void setFrom(JSONObject from)
	{
		From = from;
	}
	public void setTimeCreated(Time t)
	{
		TimeCreated = t;
	}
	
	public long getPostId()
	{
		return PostId;
	}
	public String getMessage()
	{
		return Message;
	}
	public JSONObject getFrom()
	{
		return From;
	}
	public Time getTimeCreated()
	{
		return TimeCreated;
	}

}
