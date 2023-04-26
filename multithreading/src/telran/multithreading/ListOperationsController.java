package telran.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListOperationsController {

	private static final int N_NUMBERS = 100000;
	private static final int N_THREADS = 1000;
	private static final int UPDATE_PROB = 0;
	private static final int N_RUNS = 0;

	public static void main(String[] args) {
		Integer numbers[] = new Integer[N_NUMBERS];
		Arrays.fill(numbers, 100);
		List<Integer> list = new ArrayList<>(Arrays.asList(numbers));
		ListOperations operations = new ListOperations(N_THREADS, list, 0);
		IntStream.range(0, N_THREADS).forEach(i -> {
			operations[i] = new ListOperations(UPDATE_PROB, list, N_RUNS);
			
		});
	}

}
