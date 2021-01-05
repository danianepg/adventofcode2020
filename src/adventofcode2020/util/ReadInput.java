package adventofcode2020.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInput {

	public static List<Integer> readAsListInteger(String filename) {

		List<Integer> result = new ArrayList<>();

		String fileName = "inputs\\" + filename + ".txt";
		final File file = new File(fileName);

		try (Scanner scanner = new Scanner(file)) {
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			while (scanner.hasNext()) {
				Integer line = scanner.nextInt();
				result.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<String> readAsListString(String filename) {

		List<String> result = new ArrayList<>();

		String fileName = "inputs\\" + filename + ".txt";
		final File file = new File(fileName);

		try (Scanner scanner = new Scanner(file)) {
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				result.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return result;
	}

}
