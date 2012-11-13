package com.example.socialcee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	/* app connection*/
	private Context mContext;

	private LayoutInflater mInflater;
	
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
        mInflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
		ImageView overlayImage=null;
		 View customView;
		 
		 if (convertView == null) {  // if it's not recycled, inflate
			    customView= new View(mContext) ;
		        customView = (View) mInflater.inflate(R.layout.customview, null);
		       } else {
		        customView = (View) convertView;
		    }

		    // Get the mainImageView from the parent
		    ImageView mainImage = (ImageView) customView.findViewById(R.id.mainImage);
		    mainImage.setImageResource(mImages[position]);
		  
		    overlayImage = (ImageView) customView.findViewById(R.id.overlayImage);
		    overlayImage.setImageResource(R.drawable.ic_launcher); 
		   
		    if (position==0){
		   overlayImage.setVisibility(View.VISIBLE);
		    }
		    
		    return customView;
		}

}
