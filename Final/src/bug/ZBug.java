package bug;
import info.gridworld.actor.Bug;


public class ZBug extends Bug 
{
private int stepsUntil;
private int count=1;
private int count2=0;
	public ZBug (int turnSteps)
	{
		super();
		setDirection(90);
		stepsUntil=turnSteps;
		
	}
	public ZBug (int turnSteps, java.awt.Color bugColor)
	{
		super(bugColor);
		setDirection(90);
		stepsUntil=turnSteps;
		
	}
	
	public void act ()
	{
		if(count2!=3)
		{
		move();
		count++;
		
		if (count==stepsUntil)
		{
			if (count2==0)
			{
				setDirection(225);
				
				
			}
			 
			if (count2==1)
			{
				setDirection(90);
				
				
			}
count2++;
count=1;
		}
		
	}
	}
}