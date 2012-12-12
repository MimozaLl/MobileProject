package com.example.socialcee;

//This class is used to store data (image and texts) in a ListView
public class RowItem {

	private int imageId;
	private String title;
	private String desc;

	public RowItem(int imageId, String title, String desc) {
		this.imageId = imageId;
		this.title = title;
		this.desc = desc;
	}

	public int getImageId() {
		return imageId;
	}

	public String getDesc() {
		return desc;
	}

	public String getTitle() {
		return title;
	}
}
