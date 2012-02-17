package com.mortalpowers.android.terrasteama;

public class Well extends Building {
	public Well() {
		super(10);
	}

	@Override
	public int getSteamProduction() {
		return 6;
	}
}
