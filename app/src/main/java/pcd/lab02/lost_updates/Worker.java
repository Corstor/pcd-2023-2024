package pcd.lab02.lost_updates;

import pcd.lab02.lost_updates.counter.Counter;

public class Worker extends Thread {
	
	private Counter counter;
	private int ntimes;
	
	public Worker(String name, Counter counter, int ntimes){
		super(name);
		this.counter = counter;
		this.ntimes = ntimes;
	}
	
	public void run(){
		log("started");
		for (int i = 0; i < ntimes; i++){
			counter.inc();
		}
		log("completed");
	}
	
	private void log(String msg) {
		System.out.println("[ " + this.getName() + "] " + msg);
	}
	
}
