package bug;
import info.gridworld.actor.Bug;


public class CustomPathBug extends Bug 
{
	private int[] ent;
	private boolean end = true;

	public CustomPathBug (int[] array){
		super();
		ent = array;
		
	}
	
	
	public void act ()
	{if (end)
		for(int x = 0; x < ent.length; x++)
		{ if(x==ent.length) end =false;
			if (ent[x]==1) setDirection(0);
			if (ent[x]==2) setDirection(45);
			if (ent[x]==3) setDirection(90);
			if (ent[x]==4) setDirection(135);
			if (ent[x]==5) setDirection(180);
			if (ent[x]==6) setDirection(225);
			if (ent[x]==7) setDirection(270);
			if (ent[x]==8) setDirection(315);
		move();
		}
	}
	
}
