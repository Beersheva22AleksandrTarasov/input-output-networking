package telran.io.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputOutputTest {
	String fileName = "myFile";
	static String directoryName = "myDirectory1/myDirectory2";

	@BeforeEach
	void setUp() throws Exception {
		new File(fileName).delete();
		new File(directoryName).delete();
	}

	@Test
	void testFile() throws IOException {
		File f1 = new File(fileName);
		assertTrue(f1.createNewFile());
		File dir1 = new File(directoryName);
		assertTrue(dir1.mkdirs());
		System.out.println(dir1.getAbsolutePath());

	}

	@Test
	void printDirectoryFileTest() {
		String path = "C:\\Users\\taras\\git\\repository\\input-output-networking";
		int maxLevel = 1;
		printDirectoryFile(path, maxLevel);
	}

	void printDirectoryFile(String path, int maxLevel) {
		File dirPath = new File(path);
		System.out.println(dirPath.getName() + " - root");
		if (maxLevel < 1)
			maxLevel = Integer.MAX_VALUE;
		printDirectoryFile(dirPath, maxLevel, 1);
		// path -directory path
		// maxLevel - maximal level of printing, if maxLevel < 1, all levels should be
		// printed
		// output format
		// <directory name (no points, no full absolute path)
		// <node name> - dir | file
		// <node_name> .....
		// <node name> -
		// <node name> - dir | file
		// <node_name> .....
		// <node name> -
	}

	private void printDirectoryFile(File dirPath, int maxLevel, int count) {
		if (dirPath.isDirectory()) {
			for (File item : dirPath.listFiles()) {
				printNameFile(item, count);
				if (item.isDirectory() && count < maxLevel) {
					printDirectoryFile(item, maxLevel, count + 1);
				}
			}
		}
	}

	private void printNameFile(File item, int count) {

		System.out.printf("%s%s - file \n", "	".repeat(count), item.getName(), item.isFile() ? "file" : "dir");
	}

	@Test
	void testFiles() {
		Path path = Path.of(".");
		System.out.println(path.toAbsolutePath().getNameCount());

	}

	@Test
	void printDirectoryFilesTest() throws IOException {
		String path = "C:\\Users\\taras\\git\\repository\\input-output-networking";
		int maxLevel = 5;
		printDirectoryFiles(path, maxLevel);
	}

	void printDirectoryFiles(String path, int maxLevel) throws IOException {
		Path pathDir = Path.of(path);
		System.out.println(pathDir.getFileName() + " - root");
		if (maxLevel < 1)
			maxLevel = Integer.MAX_VALUE;
		printDirectoryFiles(pathDir, maxLevel, 1);
		// path -directory path
		// maxLevel - maximal level of printing, if maxLevel < 1, all levels should be
		// printed
		// output format
		// <directory name (no points, no full absolute path)
		// <node name> - dir | file
		// <node_name> .....
		// <node name> -
		// <node name> - dir | file
		// <node_name> .....
		// <node name> -
	}

	private void printDirectoryFiles(Path pathDir, int maxLevel, int count) throws IOException {
		if (Files.isDirectory(pathDir)) {
			Object[] array = Files.list(pathDir).toArray();
			for (Object item : array) {
				printNameFiles(item, count);
				if (Files.isDirectory(Path.of(item.toString())) && count < maxLevel) {
					printDirectoryFiles((Path) item, maxLevel, count + 1);
				}
			}
		}
	}

	private void printNameFiles(Object item, int count) {
		if (Files.isDirectory(Path.of(item.toString()))) {
			System.out.printf("%s%s - dir \n", "	".repeat(count), Path.of(item.toString()).getFileName());
		} else {
			System.out.printf("%s%s - file \n", "	".repeat(count), Path.of(item.toString()).getFileName());
		}
	}

}
