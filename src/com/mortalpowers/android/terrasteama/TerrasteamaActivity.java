package com.mortalpowers.android.terrasteama;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TerrasteamaActivity extends ListActivity {
	private ArrayAdapter<String> adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> items = new ArrayList<String>();
        items.add("blah");
        items.add("glorp");
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, items);
        setListAdapter(adapter);
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
    }
}
