import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

import bug.BoxBug;


public class CultRunner {
	   public static void main(String[] args)
	    {
	        ActorWorld world = new ActorWorld();
	        NerdCult alice = new NerdCult(2,false);
	        VirusBug aids = new VirusBug(1,true);
	     
	        world.add(new Location(7, 8), alice);
	        world.add(new Location(1, 1), aids);
	        world.show();
	    }
}
