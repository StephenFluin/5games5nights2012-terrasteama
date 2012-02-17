package com.mortalpowers.android.terrasteama;

import java.util.Vector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

public class TerrasteamaActivity extends Activity {
	private BuildingAdapter adapter;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        setContentView(l);
        ListView lv = new ListView(this);
        
        Button build = new Button(this);
        build.setText("New Building");
        l.addView(build);
        
        adapter = new BuildingAdapter(Game.game.buildings);
        lv.setAdapter(adapter);
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new UpgradeBuilding());
        l.addView(lv);
    }
    
    private class BuildingAdapter extends BaseAdapter {
    	private Vector<Building> buildings;
    	
    	public BuildingAdapter(Vector<Building> b) {
    		buildings = b;
    	}

		@Override
		public int getCount() {
			return buildings.size();
		}

		@Override
		public Building getItem(int position) {
			return buildings.get(position);
		}
		
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView != null && convertView instanceof BuildingView) {
				((BuildingView)convertView).setBuilding(buildings.get(position));
				return convertView;
			} else {
				return new BuildingView(TerrasteamaActivity.this, buildings.get(position));
			}
		}
    	
    }
    
	private class UpgradeBuilding implements OnItemClickListener {
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			System.out.println("Clicked");
			AlertDialog.Builder builder = new AlertDialog.Builder(
					TerrasteamaActivity.this);
			Building b = adapter.getItem(position);
			builder.setMessage("Would you like to upgrade " + b.getName() + "?")
					.setCancelable(false)
					.setPositiveButton("Upgrade",
							new BuildingClickListener(b) {
								public void onClick(DialogInterface dialog,
										int id) {
									getBuilding().upgrade();
									dialog.cancel();
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
	
	public abstract class BuildingClickListener implements DialogInterface.OnClickListener {
		Building building;
		
		public BuildingClickListener(Building b) {
			building = b;
		}
		
		public Building getBuilding() {
			return building;
		}

		@Override
		public abstract void onClick(DialogInterface dialog, int which);
	}
}
