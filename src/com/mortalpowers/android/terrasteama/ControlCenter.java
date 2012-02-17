package com.mortalpowers.android.terrasteama;

import android.util.Log;

public class ControlCenter extends Building {

	public ControlCenter() {
		super(5, "Control Center");
		builderQuantity = 1;
	}

	@Override
	public void levelup() {
		this.level += 1;
		if(this.level > 1) {
			steamConsumption = (int) Math.round(steamConsumption * 1.5);
			builderQuantity = builderQuantity + 1;
			steamProduction = Math.round(steamProduction * 2);
		}
	}



}
