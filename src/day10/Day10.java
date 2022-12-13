package day10;

import tools.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day10 {
	static File file = new File("src/day10/problemData.txt");

	public static void main(String[] args) {
		Pattern instruction = Pattern.compile("(addx) (-?\\d+)");
		var input = FileReader.inputFileToList(file);
		var test = FileReader.inputFileToList(new File("src/day10/test.txt"));
		List<Integer> signal = new ArrayList<>();


		int x = 1;
		int cycle = 0;
		for (int i = 0; i < input.size(); i++) {

			Matcher matcher = instruction.matcher(input.get(i));

			if (matcher.matches()) {
				for (int j = 0; j < 2; j++) {
					cycle++;
					addCycle(signal, x, cycle);
				}
				x = x + Integer.parseInt(matcher.group(2));

			} else {
				cycle++;
				addCycle(signal, x, cycle);
			}
		}
		int sum = 0;
		sum = signal.get(0) * 20;
		sum = sum + (signal.get(1) * 60);
		sum = sum + (signal.get(2) * 100);
		sum = sum + (signal.get(3) * 140);
		sum = sum + (signal.get(4) * 180);
		sum = sum + (signal.get(5) * 220);
		System.out.println(sum);
		System.out.println(signal);
		System.out.println(input);


	}

	private static void addCycle(List<Integer> temp, int x, int cycle) {
		if (addXAtCycle(cycle))
			temp.add(x);
	}

	private static boolean addXAtCycle(int cycle) {
		return cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220;
	}
}
