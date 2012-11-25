package com.example.socialcee;

import org.json.JSONObject;

import android.text.format.Time;


public class Post {

	private long Id;
	private JSONObject From = new JSONObject();
	private String Message;
	private JSONObject Attachment = new JSONObject();
	private int Type;
	private JSONObject Comments = new JSONObject();
	private JSONObject Likes = new JSONObject();
	private Time TimeCreated;
	private Time TimeUpdated;
	private JSONObject Accounts = new JSONObject();
	
	public void setId(long id)
	{
		Id = id;
	}
	public void setFrom(JSONObject Actor)
	{
		From = Actor;
	}
	public void setMessage(String m)
	{
		Message = m;
	}
	public void setAttachment(JSONObject attach)
	{
		Attachment = attach;
	}
	public void setType(int t)
	{
		Type = t;
	}
	public void setComments(JSONObject comments)
	{
		Comments = comments;
	}
	public void setLikes(JSONObject likes)
	{
		Likes = likes;
	}
	public void setTimeCreated(Time t)
	{
		TimeCreated = t;
	}
	public void setTimeUpdated(Time t)
	{
		TimeUpdated = t;
	}
	public void setAccounts(JSONObject accounts)
	{
		Accounts = accounts;
	}
	
	public long getId()
	{
		return Id;
	}
	public JSONObject getFrom()
	{
		return From;
	}
	public String getMessage()
	{
		return Message;
	}
	public JSONObject getAttachment()
	{
		return Attachment;
	}
	public int getType()
	{
		return Type;
	}
	public JSONObject getComments()
	{
		return Comments;
	}
	public JSONObject getLikes()
	{
		return Likes;
	}
	public Time getTimeCreated()
	{
		return TimeCreated;
	}
	public Time getTimeUpdated()
	{
		return TimeUpdated;
	}
	public JSONObject getAccounts()
	{
		return Accounts;
	}
    
}
