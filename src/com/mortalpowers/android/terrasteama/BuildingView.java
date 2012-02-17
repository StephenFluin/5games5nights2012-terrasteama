package com.mortalpowers.android.terrasteama;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BuildingView extends LinearLayout {
	Building building;
	Context context;
	TextView name;

	public BuildingView(Context context, Building b) {
		super(context);
		name = new TextView(context);
		this.addView(name);
		setBuilding(b);
	}
	
	public void setBuilding(Building b) {
		building = b;
		name.setText(b.getName());
	}
}
