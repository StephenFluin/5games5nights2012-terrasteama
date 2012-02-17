package com.mortalpowers.android.terrasteama;

public abstract class Building {
	
	private int requiredSteam = 0;
	private int currentSteam = 0;
	private int steamConsumption = 0;
	private String name = "Unnamed";

	public Building(int consumption, String name) {
		steamConsumption = consumption;
		this.name = name;
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
	
	public void setCompletion(int steam) {
		currentSteam = steam;
		if(currentSteam > requiredSteam) {
			currentSteam = requiredSteam;
		}
	}
	public void advance(int steam) {
		setCompletion(currentSteam + steam);
	}
	
	public String getName() {
		return name;
	}
}
