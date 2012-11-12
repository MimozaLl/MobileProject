package com.example.socialcee;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SelectedGrid extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_grid);
        
        // get intent data
        Intent intent = getIntent();
        
      /**
       *  //Selected image id
       *  //Store position
        int position = i.getExtras().getInt("id");
        //connect to adapter
        ImageAdapter imageAdapter = new ImageAdapter(this);
         //display the image - layout of selected grid
        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        //get the item from the Resources
        imageView.setImageResource(imageAdapter.mImages[position]);  
       */
      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_selected_grid, menu);
        return true;
    }
}
