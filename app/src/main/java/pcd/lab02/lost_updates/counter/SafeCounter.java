package pcd.lab02.lost_updates.counter;

public class SafeCounter implements Counter{
    private int cont;
	
	public SafeCounter(int base){
		this.cont = base;
	}
	
	public void inc(){
        synchronized(this) {
            this.cont++;
        }
	}
	
	public int getValue(){
		return cont;
	}
}
