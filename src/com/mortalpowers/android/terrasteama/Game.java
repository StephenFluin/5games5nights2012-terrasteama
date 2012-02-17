package com.mortalpowers.android.terrasteama;

import java.util.Vector;

import android.util.Log;
import android.widget.Toast;

public class Game {
	public static Game game = new Game();
	public Vector<Building> buildings = new Vector<Building>();
	public int globalSteam = 50;

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
		b.magicFinish();
	}

	public int getAvailableBuilders() {
		int maxBuilds = 0;
		for (Building b : buildings) {
			maxBuilds += b.getBuilderQuantity();
		}
		return maxBuilds;
	}
	
	public int getProduction() {
		int production = 0;
		for (Building b : buildings) {
			production += b.getSteamProduction();
		}
		return production;
	}
	
	public int getConsumption() {
		int consumption = 0;
		boolean doingConstruction = false;
		for (Building b : buildings) {
			consumption += b.getSteamConsumption();
			if (!b.isComplete()) {
				doingConstruction = true;
			}
		}
		if (doingConstruction) {
			consumption += getAvailableBuilders();
		}
		return consumption;
	}

	public void tick() {
		int builders = getAvailableBuilders();

		for (Building b : buildings) {
			globalSteam += b.getSteamProduction();
			globalSteam -= b.getSteamConsumption();
			if (!b.isComplete()) {
				if (builders > 0) {
					globalSteam -= Math.min(globalSteam, builders);
					b.advance(Math.min(globalSteam, builders));
					builders = 0;
				}
			}

		}

		if (buildings.size() > 0 && globalSteam < 0) {
			int deadBuilding = 0;
			deadBuilding = (int) (Math.random() * buildings.size());
			TerrasteamaActivity.toast(buildings.get(deadBuilding).getName()
					+ " destroyed by lack of steam.", false);
			buildings.remove(deadBuilding);
			globalSteam = 1;
		}

	}

}
