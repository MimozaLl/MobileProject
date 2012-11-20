package com.example.socialcee;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Users extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_users, menu);
        return true;
    }
}
