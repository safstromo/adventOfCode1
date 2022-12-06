package day5;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class Day5 {

    static List<String> crates = new ArrayList<>();
    static List<Command> moves = new ArrayList<>();


    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/day5/problemData2.txt"))) {
            moves = reader.lines().map(Command::parseInt).toList();

        } catch (Exception ignored) {
        }


        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/day5/problemData.txt"))) {
            crates = reader.lines().toList();
        } catch (Exception ignored) {
        }


        List<Deque<String>> crates1 = new ArrayList<>();
        crates1.add(new ArrayDeque<>(Arrays.asList("Z", "J", "G")));
        crates1.add(new ArrayDeque<>(Arrays.asList("Q", "L", "R", "P", "W", "F", "V", "C")));
        crates1.add(new ArrayDeque<>(Arrays.asList("F", "P", "M", "C", "L", "G", "R")));
        crates1.add(new ArrayDeque<>(Arrays.asList("L", "F", "B", "W", "P", "H", "M")));
        crates1.add(new ArrayDeque<>(Arrays.asList("G", "C", "F", "S", "V", "Q")));
        crates1.add(new ArrayDeque<>(Arrays.asList("W", "H", "J", "Z", "M", "Q", "T", "L")));
        crates1.add(new ArrayDeque<>(Arrays.asList("H", "F", "S", "B", "V")));
        crates1.add(new ArrayDeque<>(Arrays.asList("F", "J", "Z", "S")));
        crates1.add(new ArrayDeque<>(Arrays.asList("M", "C", "D", "P", "F", "H", "B", "T")));

        List<Deque<String>> crates2 = new ArrayList<>();
        crates2.add(new ArrayDeque<>(Arrays.asList("Z", "J", "G")));
        crates2.add(new ArrayDeque<>(Arrays.asList("Q", "L", "R", "P", "W", "F", "V", "C")));
        crates2.add(new ArrayDeque<>(Arrays.asList("F", "P", "M", "C", "L", "G", "R")));
        crates2.add(new ArrayDeque<>(Arrays.asList("L", "F", "B", "W", "P", "H", "M")));
        crates2.add(new ArrayDeque<>(Arrays.asList("G", "C", "F", "S", "V", "Q")));
        crates2.add(new ArrayDeque<>(Arrays.asList("W", "H", "J", "Z", "M", "Q", "T", "L")));
        crates2.add(new ArrayDeque<>(Arrays.asList("H", "F", "S", "B", "V")));
        crates2.add(new ArrayDeque<>(Arrays.asList("F", "J", "Z", "S")));
        crates2.add(new ArrayDeque<>(Arrays.asList("M", "C", "D", "P", "F", "H", "B", "T")));

        List<String> temp = new ArrayList<>();
        Deque<String> temp2 = new ArrayDeque<>();


        moveCratesPart1(moves, crates1, temp);
        moveCratesPart2(moves, crates2, temp2);
        System.out.println("Part 1 " + crates1);
        System.out.println("Part 2 " + crates2);
    }

    private static void moveCratesPart1(List<Command> commands, List<Deque<String>> list, List<String> temp) {
        for (Command c : commands) {
            moveCrates(list, temp, c.numberOfCrates, c.fromList, c.toList);
        }
    }

    private static void moveCratesPart2(List<Command> commands, List<Deque<String>> list2, Deque<String> temp2) {
        for (Command c : commands) {
            moveCrates2(list2, temp2, c.numberOfCrates, c.fromList, c.toList);
        }
    }


    private static void moveCrates(List<Deque<String>> list, List<String> temp, int numberOfCrates, int fromList, int toList) {
        for (int i = 0; i < numberOfCrates; i++) {

            temp.add(list.get(fromList).getLast());
            list.get(fromList).removeLast();
            list.get(toList).add(temp.get(0));
            temp.clear();
        }
    }

    private static void moveCrates2(List<Deque<String>> list2, Deque<String> temp2, int numberOfCrates, int fromList, int toList) {

        for (int i = 0; i < numberOfCrates; i++) {
            temp2.add(list2.get(fromList).pollLast());
        }
        for (int i = 0; i < numberOfCrates; i++) {
            list2.get(toList).add(temp2.pollLast());
        }
    }

    record Command(int numberOfCrates, int fromList, int toList) {
        static Pattern pattern = Pattern.compile("move (\\d+) from (\\d) to (\\d)");

        static Command parseInt(String line) {
            var matcher = pattern.matcher(line);
            if (matcher.matches())
                return new Command(
                        Integer.parseInt(matcher.group(1)),
                        Integer.parseInt(matcher.group(2)) - 1,
                        Integer.parseInt(matcher.group(3)) - 1);
            return null;
        }

    }
}



