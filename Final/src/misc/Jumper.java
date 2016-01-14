package misc;
import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;


public class Jumper extends Actor 
{

	public Jumper()
	{
		super();
		setColor(Color.GREEN);
	}
	public Jumper(Color color)
	{
		super();
		setColor(color);
	}
	public void turn()
	{
		setDirection(getDirection()+45);
	}
	public void move()
	{
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
       
	}
	private boolean canMove()
	{
		
		 Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return (neighbor == null);

	}
	
	public void act()
	{
		if(canMove())
		{
		move();
		
		}
		else{
		turn();
		}
	}
}
