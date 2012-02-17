package com.mortalpowers.android.terrasteama;

public abstract class Building {
	
	private int requiredSteam = 0;
	private int currentSteam = 0;
	private int steamConsumption = 0;
	protected int builderQuantity = 0;
	protected int steamProduction = 0;
	protected int level = 1;
	private String name = "Unnamed";

	public Building(int consumption, String name) {
		steamConsumption = consumption;
		this.name = name;
	}
	
	public int getSteamProduction() {
		return steamProduction;
	}

	public int getSteamConsumption() {
		return steamConsumption;
	}

	public int getBuilderQuantity() {
		return builderQuantity;
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
	
	public String getName() {
		return name;
	}
	public void upgrade() {
		this.level +=1;
		steamConsumption = (int) Math.round(steamConsumption * 1.5);
		builderQuantity = Math.round(builderQuantity * 2);
		steamProduction = Math.round(steamProduction * 2);
		requiredSteam = (int) Math.round(requiredSteam * 1.5);
		
		
	}
}
