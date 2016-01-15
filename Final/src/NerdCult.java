import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Random;


public class NerdCult extends TeamBug{

	public NerdCult( int teamNumber, boolean canBreed)
	{
		super(teamNumber,canBreed);
		setColor(null);
	}
	
	@Override
	public void act()
	{
		super.act();

		ArrayList<Actor> targets =super.getActors();
	
		for (Actor x :targets)
		{
			TeamBug z = (TeamBug)x;
			if(sameTeam(z))
			{
				return;
			}
			else {
				Grid<Actor> gr = getGrid();
				Location imAt = z.getLocation();
				x.removeSelfFromGrid();
				NerdCult clonedCultBug = new NerdCult(2,true);
				clonedCultBug.putSelfInGrid(gr, imAt);
			}
		}
		
	}
	
	@Override
	public void interact(TeamBug bug) {
		
	}

	@Override
	public boolean canKill(TeamBug bugToKill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
public void cloneSelf() {
		
		Location loc = getLocation();
		ArrayList<Location> validLoc = getGrid().getEmptyAdjacentLocations(loc);

		if (validLoc.size() > 0) {
			Location newLocation = validLoc.get((int) Math.random() * validLoc.size());
			NerdCult newBug = new NerdCult(2, true);
			newBug.putSelfInGrid(getGrid(),newLocation);
		}

	}



}
