package bug;
import info.gridworld.actor.Bug;


public class DancingBug extends Bug {
	private int[] ent;
	private int count;
	
	public DancingBug(int[] array){
		super();
		ent = array;
	}
	
	public void act(){	
			for(int x = 0; x < ent[count]; x++)
				turn();
			move();
			move();
			count++;
			if(count == ent.length){
				count = 0;
			}
		}
		

	}


