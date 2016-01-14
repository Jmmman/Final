package critters;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class ChameleonCritter extends Critter
{  
	private static final double DARK = 0.05;	
	public void processActors(ArrayList<Actor> actorList)
    {
		int n = actorList.size();
		 if (n == 0)
		 {
		 darken();
		 return;
		 }

		 int r = (int) (Math.random() * n);
		 Actor other = actorList.get(r);
		 setColor(other.getColor()); 
    }

 
    public void makeMove(Location loc)
    {
        setDirection(getLocation().getDirectionToward(loc));
        super.makeMove(loc);
    }
    private void darken()
    {
     Color color = getColor();
     int red = (int) (color.getRed() * (1 - DARK));
     int green = (int) (color.getGreen() * (1 - DARK));
     int blue = (int) (color.getBlue() * (1 - DARK));
     setColor(new Color(red, green, blue));
   
    } 
}
