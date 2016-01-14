package bug;
import info.gridworld.actor.Bug;


public class CircleBug extends Bug 
{
private int stepsUntil;
private int count;
	public CircleBug (int turnSteps)
	{
		super();
		stepsUntil=turnSteps;
		
	}
	public CircleBug (int turnSteps, java.awt.Color bugColor)
	{
		super(bugColor);
		stepsUntil=turnSteps;
		
	}
	
	public void act ()
	{
	if (count==stepsUntil) 
	{
		turn();
		
		count=0;
	}
		if (canMove())
		{
		 move();
		 count++;
		}
		else
		{
			count=0;
			turn();
		}
		}
	
}
