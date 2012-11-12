package com.example.socialcee;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	/* app connection*/
	private Context mContext;
	
	/* Elements in the grid */
	
    public Integer[] mImages = {
    		R.drawable.posts,
    		R.drawable.users,
    		R.drawable.accounts,
    		R.drawable.posts
    };
	
	 // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

	public int getCount() {
		// TODO Auto-generated method stub
		return mImages.length;
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mImages[position];
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
		    ImageView imageView = new ImageView(mContext);
	        imageView.setImageResource(mImages[position]);
	        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	        //parameter of the image displayed
	        imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
	        return imageView;
	}

}
