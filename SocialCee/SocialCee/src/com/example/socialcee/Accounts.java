package com.example.socialcee;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Accounts extends Activity {

	public static final String[] titles = new String[] { "First Page",
			"Second Page", "Third Page", "Fourth page" };

	public static final String[] descriptions = new String[] { "description1",
			"description2", "description3", "description4" };

	public static final Integer[] images = { R.drawable.internet_connection,
			R.drawable.maks_norway, R.drawable.c, R.drawable.d };

	ListView listView;
	List<RowItem> rowItems;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < titles.length; i++) {
			RowItem item = new RowItem(images[i], titles[i], descriptions[i]);
			rowItems.add(item);
		}

		listView = (ListView) findViewById(R.id.list);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this,
				R.layout.list_item, rowItems);
		listView.setAdapter(adapter);
	}
}
