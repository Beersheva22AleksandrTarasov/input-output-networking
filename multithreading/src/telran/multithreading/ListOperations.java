package telran.multithreading;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ListOperations extends Thread {
	public ListOperations(int prodUpdate, List<Integer> list, int nRuns) {
		super();
		this.prodUpdate = prodUpdate;
		this.list = list;
		this.nRuns = nRuns;
	}

	int prodUpdate;
	List<Integer> list;
	int nRuns;

	@Override
	public void run() {
		for (int i = 0; i < nRuns; i++) {
			ThreadLocalRandom tir = ThreadLocalRandom.current();
			if (tir.nextInt(0, 100) < prodUpdate) {
				updateList();
			} else {
				readList();
			} 
		}
	}

	private void readList() {
		int size = list.size();
		for(int i = 0; i < 100; i++) {
			list.get(size-1);
		}
		
	}

	private void updateList() {
		list.remove(0);
		list.remove(0);
		list.remove(0);
		list.add(100);
		list.add(100);
		list.add(100);
		
	}
}
