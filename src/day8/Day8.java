package day8;

import tools.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day8 {

	static File file = new File("src/day8/problemData.txt");
	static String testString = """
			30373
			25512
			65332
			33549
			35390""";


	public static void main(String[] args) {
		var trees = FileReader.inputFileToList(file);
		var test = testString.lines().map(Integer::parseInt).toList();
		System.out.println(test);
		List<String> invisibleTrees = new ArrayList<>();

		for (int i = 0; i < test.size(); i++) {

			for (int j = 0; j < test.size(); j++) {
				if (i < j);

			}

		}


	}
}