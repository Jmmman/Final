package bug;
import info.gridworld.actor.Bug;


public class BoxBug extends Bug 
{
private int stepsUntil;
private int count;
	public BoxBug (int turnSteps)
	{
		super();
		stepsUntil=turnSteps;
		
	}
	public BoxBug (int turnSteps, java.awt.Color bugColor)
	{
		super(bugColor);
		stepsUntil=turnSteps;
		
	}
	
	public void act ()
	{
	if (count==stepsUntil) 
	{
		turn();
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
