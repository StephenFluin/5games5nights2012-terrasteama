package com.mortalpowers.android.terrasteama;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BuildingView extends LinearLayout {
Building building;
	public BuildingView(Context context,Building b) {
		super(context);
		building = b;
		TextView name = new TextView(context);
		name.setText(b.getName());
		this.addView(name);
	}
	

}
