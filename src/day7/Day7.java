package day7;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day7 {

	static Pattern fileName = Pattern.compile("\\b\\w+\\.\\w+");
	static Pattern dirName = Pattern.compile("dir\\s(\\S+)");


	public static void main(String[] args) {

		List<File> files = new ArrayList<>();
		List<Directory> directories = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/day7/problemData.txt"))) {
			files = reader.lines().map(File::getFile).collect(Collectors.toList());
			files.removeIf(Objects::isNull);

		} catch (Exception e) {
			e.getMessage();
		}
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/day7/problemData.txt"))) {
			directories = reader.lines().map(Directory::getFile).collect(Collectors.toList());
			directories.removeIf(Objects::isNull);

		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println(files);
		System.out.println(directories);


		String test = "$ cd /\n" +
				"$ ls\n" +
				"dir a\n" +
				"14848514 b.txt\n" +
				"8504156 c.dat\n" +
				"dir d\n" +
				"$ cd a\n" +
				"$ ls\n" +
				"dir e\n" +
				"29116 f\n" +
				"2557 g\n" +
				"62596 h.lst\n" +
				"$ cd e\n" +
				"$ ls\n" +
				"584 i\n" +
				"$ cd ..\n" +
				"$ cd ..\n" +
				"$ cd d\n" +
				"$ ls\n" +
				"4060174 j\n" +
				"8033020 d.log\n" +
				"5626152 d.ext\n" +
				"7214296 k";

		var test2 = test.lines().map(File::getFile).collect(Collectors.toList());
		test2.removeIf(Objects::isNull);
		System.out.println(test2);

		var test3 = test.lines().map(Directory::getFile).collect(Collectors.toList());
		test3.removeIf(Objects::isNull);
		System.out.println(test3);

	}

	static class Directory {
		String name;
		static List<File> files = new ArrayList<>();
		static Pattern pattern = Pattern.compile("dir\\s(\\S+)");

		static Directory getFile(String line) {
			var matcher = pattern.matcher(line);
			if (matcher.matches())
				return new Directory(matcher.group(1));
			return null;
		}

		public Directory(String name) {
			this.name = name;
		}

		public static List<File> getFiles() {
			return files;
		}

		public static void addFiles(File file){
			files.add(file);
		}

		private static void printSize() {
			int dirSize = 0;

			for (File file : files) {
				dirSize = dirSize + file.size();
			}
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "InputDir{" +
					"name='" + name + '\'' +
					'}';
		}
	}

}


record File(int size, String name) {

	static Pattern pattern = Pattern.compile("(\\d+)\\s(\\S+)");

	static File getFile(String line) {
		var matcher = pattern.matcher(line);
		if (matcher.matches())
			return new File(Integer.parseInt(matcher.group(1)),
					matcher.group(2));
		return null;
	}

}

