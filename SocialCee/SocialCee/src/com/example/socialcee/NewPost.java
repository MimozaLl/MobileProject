package com.example.socialcee;


import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NewPost extends Activity {

	
	EditText uploadedlink,constant,textTargetUri;
	TextView add_photo,add_link,addurl,title,description;
	ImageView add_image,addlink,choose;
	Button upload, back, load,back_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        
        //set the layouts to invisible
        
        title =(TextView)findViewById(R.id.editText2);
        title.setVisibility(View.INVISIBLE);
        description =(TextView)findViewById(R.id.editText3);
        description.setVisibility(View.INVISIBLE);
        upload =(Button)findViewById(R.id.button2);
        upload.setVisibility(View.INVISIBLE);
        add_link =(TextView)findViewById(R.id.textView3);
        add_image =(ImageView)findViewById(R.id.imageView1);
        addlink =(ImageView)findViewById(R.id.imageView2);
        choose =(ImageView)findViewById(R.id.imageView3);
        choose.setVisibility(View.INVISIBLE);
        back=(Button)findViewById(R.id.button3);
        back.setVisibility(View.INVISIBLE);
        load=(Button)findViewById(R.id.button4);
        load.setVisibility(View.INVISIBLE);
        addurl=(TextView)findViewById(R.id.editText4);
        addurl.setVisibility(View.INVISIBLE);
        back_link=(Button)findViewById(R.id.button5);
        back_link.setVisibility(View.INVISIBLE);
        uploadedlink=(EditText)findViewById(R.id.editText5);
        uploadedlink.setVisibility(View.INVISIBLE);
        uploadedlink.setText(" ");
   //     textTargetUri=(EditText)findViewById(R.id.editText6);
        
        //on click of the add_photo text
        add_photo =(TextView)findViewById(R.id.textView2);
        add_photo.setOnClickListener(new View.OnClickListener() {
		
        
        
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add_photo.setVisibility(View.INVISIBLE);
				add_link.setVisibility(View.INVISIBLE);
				add_image.setVisibility(View.INVISIBLE);
				addlink.setVisibility(View.INVISIBLE);
				
				title.setVisibility(View.VISIBLE);
				description.setVisibility(View.VISIBLE);
				upload.setVisibility(View.VISIBLE);
				choose.setVisibility(View.VISIBLE);
				back.setVisibility(View.VISIBLE);
				upload.setOnClickListener(new View.OnClickListener() {
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
						      startActivityForResult(intent, 0);
					}
					public void onActivityResult(int requestCode, int resultCode, Intent data) {
						    // TODO Auto-generated method stub
						    this.onActivityResult(requestCode, resultCode, data);

						    if (resultCode == RESULT_OK){
						     Uri targetUri = data.getData();
						     
							textTargetUri.setText(targetUri.toString());
						     Bitmap bitmap;
						     
						     try {
						      bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
				
							choose.setImageBitmap(bitmap);
							choose.showContextMenu();
						     } catch (FileNotFoundException e) {
						      // TODO Auto-generated catch block
						      e.printStackTrace();
						     }
						    }
						    }
						    
				});
			}
		});
        
        back.setOnClickListener(new View.OnClickListener(){

			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				add_photo.setVisibility(View.VISIBLE);
				add_link.setVisibility(View.VISIBLE);
				add_image.setVisibility(View.VISIBLE);
				addlink.setVisibility(View.VISIBLE);
				
				title.setVisibility(View.INVISIBLE);
				description.setVisibility(View.INVISIBLE);
				upload.setVisibility(View.INVISIBLE);
				choose.setVisibility(View.INVISIBLE);
				back.setVisibility(View.INVISIBLE);
			}
        	
        });
        
        add_image.setOnClickListener(new View.OnClickListener() {
    		
            
            
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add_photo.setVisibility(View.INVISIBLE);
				add_link.setVisibility(View.INVISIBLE);
				add_image.setVisibility(View.INVISIBLE);
				addlink.setVisibility(View.INVISIBLE);
				
				title.setVisibility(View.VISIBLE);
				description.setVisibility(View.VISIBLE);
				upload.setVisibility(View.VISIBLE);
				choose.setVisibility(View.VISIBLE);
				back.setVisibility(View.VISIBLE);
				
				upload.setOnClickListener(new View.OnClickListener() {
					
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
						      startActivityForResult(intent, 0);
					}
					protected void onActivityResult(int requestCode, int resultCode, Intent data) {
						    // TODO Auto-generated method stub
						    this.onActivityResult(requestCode, resultCode, data);

						    if (resultCode == RESULT_OK){
						    	   Uri targetUri = data.getData();
						    	   
								textTargetUri.setText(targetUri.toString());
						    	   
						    	   Toast.makeText(getApplicationContext(), 
						    	     "ImageView: " + choose.getWidth() + " x " + choose.getHeight(), 
						    	     Toast.LENGTH_LONG).show();
						    	   
						    	   Bitmap bitmap;
						    	   bitmap = decodeSampledBitmapFromUri(
						    	     targetUri,
						    	     choose.getWidth(), choose.getHeight());
						    	      
						    	   if(bitmap == null){
						    	    Toast.makeText(getApplicationContext(), "the image data could not be decoded", Toast.LENGTH_LONG).show();
						    	    
						    	   }else{
						    	    Toast.makeText(getApplicationContext(), 
						    	      "Decoded Bitmap: " + bitmap.getWidth() + " x " + bitmap.getHeight(), 
						    	      Toast.LENGTH_LONG).show();
						    	    choose.setImageBitmap(bitmap);
						    	   } 
						    	  }
						    	 }
						    	 
						    	 /*
						    	  *  How to "Loading Large Bitmaps Efficiently"?
						    	  *  Refer: http://developer.android.com/training/displaying-bitmaps/load-bitmap.html
						    	  */
						    	 
						    	 public Bitmap decodeSampledBitmapFromUri(Uri uri, int reqWidth, int reqHeight) {

						    	  Bitmap bm = null;
						    	  
						    	  try{
						    	   // First decode with inJustDecodeBounds=true to check dimensions
						    	   final BitmapFactory.Options options = new BitmapFactory.Options();
						    	   options.inJustDecodeBounds = true;
						    	   BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);

						    	      // Calculate inSampleSize
						    	      options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

						    	      // Decode bitmap with inSampleSize set
						    	      options.inJustDecodeBounds = false;
						    	      bm = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
						    	  } catch (FileNotFoundException e) {
						    	   e.printStackTrace();
						    	   Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
						    	  }
						    	  
						    	     return bm;
						    	 }
						    	    
						    	 public int calculateInSampleSize(
						    	   BitmapFactory.Options options, int reqWidth, int reqHeight) {
						    	  // Raw height and width of image
						    	  final int height = options.outHeight;
						    	  final int width = options.outWidth;
						    	  int inSampleSize = 1;
						    	  
						    	  if (height > reqHeight || width > reqWidth) {
						    	   if (width > height) {
						    	    inSampleSize = Math.round((float)height / (float)reqHeight); 
						    	   } else {
						    	    inSampleSize = Math.round((float)width / (float)reqWidth); 
						    	   } 
						    	  }
						    	  return inSampleSize; 
						    	 
						    }
						    
				});
			}
		});
        addlink.setOnClickListener(new View.OnClickListener() {
    		
            
            
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add_photo.setVisibility(View.INVISIBLE);
				add_link.setVisibility(View.INVISIBLE);
				add_image.setVisibility(View.INVISIBLE);
				addlink.setVisibility(View.INVISIBLE);
				
				
				title.setVisibility(View.INVISIBLE);
				description.setVisibility(View.INVISIBLE);
				upload.setVisibility(View.INVISIBLE);
				choose.setVisibility(View.INVISIBLE);
				back.setVisibility(View.INVISIBLE);
				addurl.setVisibility(View.VISIBLE);
				load.setVisibility(View.VISIBLE);
				back_link.setVisibility(View.VISIBLE);
				upload.setOnClickListener(new View.OnClickListener() {
			    	
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
					}
			
						    
				});
			}
		});
        back_link.setOnClickListener(new OnClickListener(){

			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				add_photo.setVisibility(View.VISIBLE);
				add_link.setVisibility(View.VISIBLE);
				add_image.setVisibility(View.VISIBLE);
				addlink.setVisibility(View.VISIBLE);
				
				addurl.setText(" ");
				
				title.setVisibility(View.INVISIBLE);
				description.setVisibility(View.INVISIBLE);
				upload.setVisibility(View.INVISIBLE);
				choose.setVisibility(View.VISIBLE);
				back.setVisibility(View.INVISIBLE);
				addurl.setVisibility(View.INVISIBLE);
				load.setVisibility(View.INVISIBLE);
				back_link.setVisibility(View.INVISIBLE);
				uploadedlink.setVisibility(View.INVISIBLE);
				
			}
        	
        });
        
 add_link.setOnClickListener(new View.OnClickListener() {
    		
            
            
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				add_photo.setVisibility(View.INVISIBLE);
				add_link.setVisibility(View.INVISIBLE);
				add_image.setVisibility(View.INVISIBLE);
				addlink.setVisibility(View.INVISIBLE);
				
				title.setVisibility(View.INVISIBLE);
				description.setVisibility(View.INVISIBLE);
				upload.setVisibility(View.INVISIBLE);
				choose.setVisibility(View.INVISIBLE);
				back.setVisibility(View.INVISIBLE);
				addurl.setVisibility(View.VISIBLE);
				load.setVisibility(View.VISIBLE);
				back_link.setVisibility(View.VISIBLE);
				
				
			upload.setOnClickListener(new View.OnClickListener() {
					
					
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
			
						    
				});
			}
		});
   load.setOnClickListener(new View.OnClickListener(){

	
	public void onClick(View arg0) {
        
		String thelinkstring;
		//uploadedlink.setVisibility(View.VISIBLE);
	//	addurl.setVisibility(View.INVISIBLE);
		thelinkstring=addurl.getText().toString();
		if(thelinkstring==null)
		{
			addurl.setVisibility(View.VISIBLE);
			uploadedlink.setVisibility(View.INVISIBLE);
		}
		else
		{
	    uploadedlink.setVisibility(View.VISIBLE);
	    addurl.setVisibility(View.INVISIBLE);
		uploadedlink.setText(thelinkstring);
		
	    
		}
		
	}
	   
   });
   
  
    }

    
}

