package com.example.socialcee;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Accounts extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_accounts, menu);
        return true;
    }
}
