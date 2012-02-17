package com.mortalpowers.android.terrasteama;

import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TerrasteamaActivity extends ListActivity {
	private ArrayAdapter<String> adapter;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> items = new ArrayList<String>();
        Vector<Building> building = Game.game.buildings;
        for (Building b : building) {
        	items.add(b.getName());
        }
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, items);
        setListAdapter(adapter);
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new UpgradeBuilding());
    }
    
	private class UpgradeBuilding implements OnItemClickListener {
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			System.out.println("Clicked");
			AlertDialog.Builder builder = new AlertDialog.Builder(
					TerrasteamaActivity.this);
			String name = adapter.getItem(position);
			builder.setMessage("Would you like to upgrade " + name + "?")
					.setCancelable(false)
					.setPositiveButton("Upgrade",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									TerrasteamaActivity.this.finish();
								}
							})
					.setNegativeButton("Not Yet",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			AlertDialog alert = builder.create();
			alert.show();
		}
	}
}
