package critters;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
public class RockHound extends Critter
{

 public void processActors(ArrayList<Actor> actor)
 {
 for (Actor actor2 : actor)
 {
 if (actor2 instanceof Rock)
 {
	 actor2.removeSelfFromGrid();
 }
 }
 }
} 