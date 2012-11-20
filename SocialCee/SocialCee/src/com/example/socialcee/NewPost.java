package com.example.socialcee;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class NewPost extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_new_post, menu);
        return true;
    }
}
