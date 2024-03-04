package pcd.lab02.lost_updates;

public class UnsafeCounter implements Counter {

	private int cont;
	
	public UnsafeCounter(int base){
		this.cont = base;
	}
	
	public void inc(){
		cont++;
	}
	
	public int getValue(){
		return cont;
	}
}
