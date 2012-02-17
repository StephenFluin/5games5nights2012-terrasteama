package com.mortalpowers.android.terrasteama;

public abstract class Building {
	
	private int requiredSteam = 0;
	private int currentSteam = 0;
	private int steamConsumption = 0;

	public Building(int consumption) {
		steamConsumption = consumption;
	}
	
	public int getSteamProduction() {
		return 0;
	}

	public int getSteamConsumption() {
		return steamConsumption;
	}

	public int getBuilderQuantity() {
		return 0;
	}
	public int getRequiredSteam () {
		return requiredSteam;
	}
	public boolean isComplete() {
		return (currentSteam >= requiredSteam);
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
