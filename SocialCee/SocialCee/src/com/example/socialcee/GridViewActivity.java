package com.example.socialcee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GridViewActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        
        /* Never ever name the actity GridView
         */
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        
        // Instance of ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this));
        
        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {
            	/** Send item to new activity 
            	 * LINDA !!! new class to distinguish which activity to connect
            	 * test this how it goes
            	 * MISSING: (Nuhi +Ylli+Mimoza)'s part,**/
            	Intent intent = new Intent(getApplicationContext(), SelectedGrid.class);
            	
            	// passing array index -position
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ctivity_grid_view, menu);
        return true;
    }
}
