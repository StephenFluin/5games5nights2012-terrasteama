package com.mortalpowers.android.terrasteama;

import java.util.Vector;

import android.widget.Toast;

public class Game {
	public static Game game = new Game();
	public Vector<Building> buildings = new Vector<Building>();
	public int globalSteam = 0;

	public Game() {
		game = this;
		addFinishedBuilding(new Well());
		addFinishedBuilding(new ControlCenter());
	}

	public void addBuilding(Building b) {
		buildings.add(b);
	}

	public void addFinishedBuilding(Building b) {
		buildings.add(b);
		b.setCompletion(b.getRequiredSteam());
	}

	public int getOngoingBuilds() {
		int ongoingBuilds = 0;
		for (Building b : buildings) {
			if (b.isComplete()) {
				ongoingBuilds++;
			}
		}
		return ongoingBuilds;
	}

	public int getAvailableBuilds() {
		int maxBuilds = 0;
		for (Building b : buildings) {
			maxBuilds += b.getBuilderQuantity();
		}
		return maxBuilds - getOngoingBuilds();

	}
	
	public void tick() {
		for (Building b : buildings) {
			globalSteam += b.getSteamProduction();
			globalSteam -= b.getSteamConsumption();
			
		}
		int deadBuilding = 0;
		if(globalSteam < 0) {
			deadBuilding = (int) (Math.random() * buildings.size());
		}
		TerrasteamaActivity.toast(buildings.get(deadBuilding).getName() + " destroyed by lack of steam.", true);
		buildings.remove(deadBuilding);
		
	}
	

}
