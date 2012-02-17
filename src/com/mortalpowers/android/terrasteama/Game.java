package com.mortalpowers.android.terrasteama;

import java.util.Vector;

public class Game {
	public static Game game = new Game();
	public Vector<Building> buildings = new Vector<Building>();

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
}
