package telran.multithreading.kolhoz;

public class Truck extends Thread {
	private int load;
	private static long elevator1;
	private static long elevator2;
	private final static Object mutex = new Object();
			
	private int nRuns;

	@Override
	public void run() {
		for (int i = 0; i < nRuns; i++) {
			loadElevator1(load);
			loadElevator2(load);
		}
	}

	public Truck(int load, int nRuns) {
		
		this.load = load;
		this.nRuns = nRuns;
	}

	synchronized static void loadElevator2(int load) {
		elevator2 += load;
		
	}

	 static void loadElevator1(int load) {
		synchronized (mutex) {
			elevator1 += load;
		}
	}
	
	public static long getElevator1() {
		return elevator1;
	}
	
	public static long getElevator2() {
		return elevator2;
	}
}
