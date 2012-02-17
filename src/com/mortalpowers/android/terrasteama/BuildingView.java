package com.mortalpowers.android.terrasteama;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class BuildingView extends TableLayout {
	Building building;
	Context context;
	TextView name;
	LinearLayout dataItems;

	public BuildingView(Context context, Building b) {
		super(context);
		this.context = context;
		
		this.setStretchAllColumns(true);
		TableRow r = new TableRow(context);
		addView(r);
		
		
		name = new TextView(context);
		r.addView(name);
		
		
		
		dataItems = new LinearLayout(context);
		dataItems.setOrientation(VERTICAL);
		r.addView(dataItems);
		
		
		setBuilding(b);
		
		

	}

	public void setBuilding(Building b) {
		building = b;
		name.setText(b.getName());
		dataItems.removeAllViews();
		TextView t;
		if (b.getSteamProduction() > 0) {
			 t = new TextView(context);
			 t.setGravity(Gravity.RIGHT);
			dataItems.addView(t);
			t.setText("Production: " + b.getSteamProduction());
		}
		if (b.getSteamConsumption() > 0) {
			t = new TextView(context);
			t.setGravity(Gravity.RIGHT);
			dataItems.addView(t);
			t.setText("Consumption: "
					+ b.getSteamConsumption());
		}
		if (b.getBuilderQuantity() > 0) {
			t = new TextView(context);
			t.setGravity(Gravity.RIGHT);
			dataItems.addView(t);
			t.setText("Builders: "
					+ b.getBuilderQuantity());
		}
	}
}
