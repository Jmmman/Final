package bug;
import info.gridworld.actor.Bug;


public class SpiralBug extends Bug 
{
private int stepsUntil;
private int count;
	public SpiralBug (int turnSteps)
	{
		super();
		stepsUntil=turnSteps;
		
	}
	public SpiralBug (int turnSteps, java.awt.Color bugColor)
	{
		super(bugColor);
		stepsUntil=turnSteps;
		
	}
	
	public void act ()
	{
		if(stepsUntil!=0) {
	if (count==stepsUntil) 
	{
		turn();
		
		count=0;
		 stepsUntil--;
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
	}

