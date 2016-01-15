
import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class VirusBug extends TeamBug {

	public VirusBug(int tN, boolean hasBred) {
		super(tN,hasBred);
		setColor(Color.YELLOW);
		int r = ((int) (Math.random() * 8)) * 45;
		setDirection(r);
	}

	@Override
	public void interact(TeamBug bug) {
		if (!sameTeam(bug) && !isInfected()) {
			infect(bug, 4);
		}
	}

	@Override
	public boolean canKill(TeamBug bugToKill) {
		return true;
	}

	@Override
	public void cloneSelf() {
		
		Location loc = getLocation();
		ArrayList<Location> validLoc = getGrid().getEmptyAdjacentLocations(loc);

		if (validLoc.size() > 0) {
			Location newLocation = validLoc.get((int) Math.random() * validLoc.size());
			VirusBug newBug = new VirusBug(1, true);
			newBug.putSelfInGrid(getGrid(),newLocation);
		}

	}

}

