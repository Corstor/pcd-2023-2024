package pcd.lab02.lost_updates;

public class TestLostUpdates {

	public static void main(String[] args) throws Exception {
		
		int ntimes = 100000; // try with different values: 100, 200, 1000, 5000, ...
		
		Counter c = new UnsafeCounter(0);
		Worker w1 = new Worker("Worker-A", c, ntimes);
		Worker w2 = new Worker("Worker-B", c, ntimes);

		Cron cron = new Cron();
		cron.start();
		
		w1.start();
		w2.start();

		w1.join();
		w2.join();

		Counter safeCounter = new SafeCounter(0);
		Worker w3 = new Worker("Worker-A", safeCounter, ntimes);
		Worker w4 = new Worker("Worker-B", safeCounter, ntimes);
		
		w3.start();
		w4.start();

		w3.join();
		w4.join();
		
		cron.stop();
		
		System.out.println("Counter final value UNSAFE: " + c.getValue());
		System.out.println("Counter final value SAFE: " + safeCounter.getValue() + " in " + cron.getTime()+"ms.");
	}
}
