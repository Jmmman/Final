package misc;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;


public class JumperRunner {
	 public static void main(String[] args)
	    {
	        ActorWorld world = new ActorWorld();

	       Jumper bob = new Jumper();
	        
	        world.add(new Location(5, 5), bob);
	       
	        world.show();
	    }

}
