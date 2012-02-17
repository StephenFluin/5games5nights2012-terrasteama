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
}
