package com.mortalpowers.android.terrasteama;

import android.util.Log;

public class Well extends Building {
	public Well() {
		super( 0, "Well");
		steamProduction = 6;
	}

	@Override
	public void levelup() {
		this.level += 1;
		if(this.level > 1) {
					steamConsumption = (int) Math.round(steamConsumption * 1.5);
					steamProduction = Math.round(steamProduction * 2);
		}
	}
	
	
}
