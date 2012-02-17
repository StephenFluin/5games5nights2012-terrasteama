package com.mortalpowers.android.terrasteama;

import android.util.Log;

public abstract class Building {

	private int requiredSteam = 0;
	private int currentSteam = 0;
	protected int steamConsumption = 0;
	protected int builderQuantity = 0;
	protected int steamProduction = 0;
	protected int level = 0;
	private String name = "Unnamed";

	public Building(int consumption, String name) {
		steamConsumption = consumption;
		this.name = name;
		upgrade();
	}

	public int getSteamProduction() {
		return (level == 0 || !isComplete() ? 0 : steamProduction);
	}

	public int getSteamConsumption() {
		return (level == 0 || !isComplete() ? 0 : steamConsumption);
	}

	public int getBuilderQuantity() {
		return (level == 0 || !isComplete()  ? 0 : builderQuantity);
	}

	public int getRequiredSteam() {
		return requiredSteam;
	}

	public boolean isComplete() {
		boolean result = (currentSteam >= requiredSteam);

		return result;
	}
	
	public void setCompletion(int steam) {
		currentSteam = steam;
		if (currentSteam >= requiredSteam) {
			levelup();
			
		}
	}
	
	public void advance(int steam) {
		setCompletion(currentSteam + steam);
	}

	public String getName() {
		return name;
	}

	public void upgrade() {
		if (level == 0) {
			requiredSteam = 20;
		} else {
			requiredSteam = (int) (200 * Math.pow(level, 2));
		}
		Log.d("terrasteama","Required steam is now " + requiredSteam);
		Log.d("terrasteama", "Isocmplete? " + isComplete() + " current is " + currentSteam);

	}

	/**
	 * Advance the building to the next level of consumption and production.
	 */
	public abstract void levelup() ;

	public int getCurrentSteam() {
		return currentSteam;
	}

	public void magicFinish() {
		currentSteam = requiredSteam;
		levelup();
		
	}
}
