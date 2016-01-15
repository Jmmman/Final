

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

//Version 1.02
//@Author Suchir/Billy, and everyone who helped figure this out on the whiteboard
//Any edits/improvements are appreciated
//Not sure if we need final for the methods, but it seemed useful
public abstract class TeamBug extends Critter {
	private int team;
	private boolean isSterile;
	private int turnsToDeath;
	private boolean isInfected;
	private boolean canKill;
	private int turnsToUnfreeze;

	public static final int GEEK = 1;
	public static final int NERD = 2;


	public TeamBug(int teamNum, boolean hasBred) {
		super();
		team = teamNum;
		isSterile = hasBred;
		turnsToDeath = -1;
	}

	// How your bug interacts with other bugs
	public abstract void interact(TeamBug bug);

	// Determines whether your bug (this) can kill the other bug (bugToKill)
	public abstract boolean canKill(TeamBug bugToKill);

	// Used in breeding, just make a new bug of the same type as yours in an
	// adjascent square
	public abstract void cloneSelf();

	public int getTurnsToDeath() {
		return turnsToDeath;
	}

	public boolean isInfected() {
		return isInfected;
	}

	public boolean canKill() {
		return canKill;
	}

	public int getTurnsToUnfreeze() {
		return turnsToUnfreeze;
	}

	// Determines if the two bugs are on the same team
	public boolean sameTeam(TeamBug bug) {
		return team == bug.team;
	}

	// Your bug (this) kills the other bug (bugToBeKilled) if it can
	public final void kill(TeamBug bugToBeKilled) {
		if (canKill(bugToBeKilled)) {
			bugToBeKilled.removeSelfFromGrid();
		}
	}

	public final void resurrect(TeamBug bugToResurrect) {
		bugToResurrect.turnsToDeath = -1;
	}

	// Heals the parameter TeamBug
	public final void heal(TeamBug bug) {
		bug.turnsToDeath = -1;
	}

	// Your bug infects the other bug so that it has i turns left before it dies
	public final void infect(TeamBug bug, int i) {
		bug.isInfected = true;
		bug.turnsToDeath = i;
	}

	// Your bug freezes the other bug so that it has i turns left before it can
	// move
	public final void freeze(TeamBug bug, int i) {
		bug.turnsToUnfreeze = i;
	}

	// Breeds your bug, to be run during every act method
	public final void breed() {
		if (isSterile)
			return;
		int random = (int) (Math.random() * 10);
		if (random == 3) {
			cloneSelf();
			isSterile = true;
		}
	}

	public void processActors(ArrayList<Actor> actors) {
		for (Actor a : actors) {
			if (a instanceof TeamBug)
				interact((TeamBug) a);
		}
	}

	public final void makeMove(Location loc) {
		turnsToUnfreeze--;
		turnsToDeath--;
		if (turnsToDeath == 0)
			removeSelfFromGrid();
		if (loc == null)
			removeSelfFromGrid();
		else if (turnsToUnfreeze >= 0)
			return;
		else
			moveTo(loc);
	}

	public void act() {
		super.act();
		breed();
	}
}

