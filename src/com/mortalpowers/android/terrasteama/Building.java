package com.mortalpowers.android.terrasteama;

public abstract class Building {
	
	private int requiredSteam = 0;
	private int currentSteam = 0;

	public int getSteamProduction() {
		return 0;
	}

	public int getSteamConsumption() {
		return 0;
	}

	public int getBuilderQuantity() {
		return 0;
	}
	public int getRequiredSteam () {
		return requiredSteam;
	}
	
	public void setCompletion(int steam) {
		currentSteam = steam;
		if(currentSteam > requiredSteam) {
			currentSteam = requiredSteam;
		}
	}
	public void advance(int steam) {
		setCompletion(currentSteam + steam);
	}
	
	
}
