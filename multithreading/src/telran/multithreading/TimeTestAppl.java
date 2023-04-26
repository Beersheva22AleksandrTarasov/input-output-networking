package telran.multithreading;

public class TimeTestAppl {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		
		timer.start();
		Thread.sleep(5000);
		timer.interrupt();
		Thread.sleep(5000);
		Thread mainThread = Thread.currentThread();
		mainThread.interrupt();
		Thread.sleep(1000000000000l);

	}

}
