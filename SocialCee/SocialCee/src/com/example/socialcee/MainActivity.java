package com.example.socialcee;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      
        /*Button to connect to GridView Activity
       * First activity after Log in*/        
       Button internal_data =(Button)findViewById(R.id.button);
        // New intent when Location clicked
        internal_data.setOnClickListener( new Button.OnClickListener()
   	 {
   		 public void onClick(View view){
   			 Intent gridView = new Intent(MainActivity.this, GridViewActivity.class);
    		 	startActivity(gridView); 
   		 }
   	});
          
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
