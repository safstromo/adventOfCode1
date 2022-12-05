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

        List<Command> commands = COMMAND.lines().map(Command::parseInt).toList();


        List<Deque<String>> list = new ArrayList<>();
        list.add(new ArrayDeque<>(Arrays.asList("Z", "J", "G")));
        list.add(new ArrayDeque<>(Arrays.asList("Q", "L", "R", "P", "W", "F", "V", "C")));
        list.add(new ArrayDeque<>(Arrays.asList("F", "P", "M", "C", "L", "G", "R")));
        list.add(new ArrayDeque<>(Arrays.asList("L", "F", "B", "W", "P", "H", "M")));
        list.add(new ArrayDeque<>(Arrays.asList("G", "C", "F", "S", "V", "Q")));
        list.add(new ArrayDeque<>(Arrays.asList("W", "H", "J", "Z", "M", "Q", "T", "L")));
        list.add(new ArrayDeque<>(Arrays.asList("H", "F", "S", "B", "V")));
        list.add(new ArrayDeque<>(Arrays.asList("F", "J", "Z", "S")));
        list.add(new ArrayDeque<>(Arrays.asList("M", "C", "D", "P", "F", "H", "B", "T")));

        List<Deque<String>> list2 = new ArrayList<>();
        list2.add(new ArrayDeque<>(Arrays.asList("Z", "J", "G")));
        list2.add(new ArrayDeque<>(Arrays.asList("Q", "L", "R", "P", "W", "F", "V", "C")));
        list2.add(new ArrayDeque<>(Arrays.asList("F", "P", "M", "C", "L", "G", "R")));
        list2.add(new ArrayDeque<>(Arrays.asList("L", "F", "B", "W", "P", "H", "M")));
        list2.add(new ArrayDeque<>(Arrays.asList("G", "C", "F", "S", "V", "Q")));
        list2.add(new ArrayDeque<>(Arrays.asList("W", "H", "J", "Z", "M", "Q", "T", "L")));
        list2.add(new ArrayDeque<>(Arrays.asList("H", "F", "S", "B", "V")));
        list2.add(new ArrayDeque<>(Arrays.asList("F", "J", "Z", "S")));
        list2.add(new ArrayDeque<>(Arrays.asList("M", "C", "D", "P", "F", "H", "B", "T")));

        List<String> temp = new ArrayList<>();
        Deque<String> temp2 = new ArrayDeque<>();


        moveCratesPart1(moves, list, temp);
        moveCratesPart2(moves, list2, temp2);
        System.out.println("Part 1 " + list);
        System.out.println("Part 2 " + list2);
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

    public static final String COMMAND = """
            move 1 from 5 to 6
            move 5 from 6 to 7
            move 10 from 7 to 3
            move 4 from 8 to 4
            move 2 from 5 to 4
            move 4 from 3 to 6
            move 6 from 2 to 4
            move 8 from 6 to 9
            move 5 from 9 to 2
            move 7 from 2 to 7
            move 2 from 1 to 4
            move 3 from 3 to 8
            move 1 from 5 to 9
            move 1 from 3 to 8
            move 1 from 1 to 2
            move 11 from 4 to 6
            move 2 from 5 to 6
            move 10 from 9 to 1
            move 4 from 8 to 3
            move 7 from 7 to 1
            move 9 from 1 to 2
            move 1 from 6 to 5
            move 1 from 5 to 9
            move 5 from 3 to 8
            move 2 from 9 to 1
            move 5 from 3 to 9
            move 3 from 6 to 8
            move 5 from 9 to 6
            move 6 from 6 to 3
            move 3 from 3 to 2
            move 1 from 9 to 8
            move 13 from 2 to 3
            move 3 from 8 to 1
            move 11 from 1 to 4
            move 3 from 4 to 1
            move 2 from 6 to 5
            move 4 from 6 to 8
            move 17 from 3 to 9
            move 1 from 1 to 8
            move 1 from 6 to 5
            move 1 from 3 to 7
            move 1 from 7 to 4
            move 3 from 4 to 1
            move 1 from 3 to 8
            move 4 from 8 to 1
            move 3 from 5 to 9
            move 1 from 6 to 4
            move 4 from 4 to 8
            move 2 from 8 to 4
            move 2 from 1 to 6
            move 4 from 8 to 6
            move 1 from 8 to 3
            move 6 from 6 to 3
            move 6 from 3 to 9
            move 6 from 1 to 4
            move 5 from 8 to 4
            move 1 from 3 to 6
            move 3 from 1 to 7
            move 1 from 6 to 7
            move 4 from 4 to 5
            move 24 from 9 to 5
            move 2 from 9 to 1
            move 27 from 5 to 7
            move 13 from 7 to 2
            move 1 from 5 to 9
            move 7 from 2 to 7
            move 1 from 9 to 8
            move 5 from 2 to 8
            move 1 from 2 to 5
            move 1 from 5 to 7
            move 21 from 4 to 1
            move 1 from 4 to 6
            move 1 from 6 to 5
            move 22 from 7 to 5
            move 2 from 7 to 8
            move 7 from 5 to 4
            move 1 from 4 to 5
            move 2 from 7 to 9
            move 5 from 5 to 2
            move 5 from 4 to 2
            move 3 from 5 to 1
            move 7 from 8 to 7
            move 1 from 4 to 1
            move 23 from 1 to 8
            move 2 from 9 to 4
            move 11 from 8 to 3
            move 3 from 1 to 3
            move 1 from 4 to 2
            move 12 from 3 to 2
            move 7 from 7 to 3
            move 3 from 2 to 1
            move 1 from 4 to 9
            move 1 from 1 to 3
            move 9 from 8 to 6
            move 2 from 5 to 4
            move 3 from 1 to 7
            move 3 from 2 to 4
            move 7 from 2 to 3
            move 9 from 3 to 4
            move 7 from 5 to 2
            move 2 from 7 to 2
            move 1 from 7 to 2
            move 13 from 4 to 6
            move 1 from 9 to 8
            move 2 from 8 to 2
            move 12 from 2 to 1
            move 3 from 3 to 1
            move 1 from 8 to 1
            move 5 from 3 to 7
            move 3 from 2 to 8
            move 7 from 2 to 5
            move 3 from 8 to 3
            move 1 from 4 to 8
            move 22 from 6 to 4
            move 1 from 3 to 6
            move 3 from 5 to 8
            move 4 from 5 to 8
            move 1 from 3 to 9
            move 8 from 4 to 2
            move 8 from 8 to 3
            move 1 from 6 to 3
            move 4 from 2 to 6
            move 1 from 9 to 4
            move 5 from 3 to 9
            move 2 from 8 to 1
            move 3 from 2 to 1
            move 10 from 4 to 8
            move 4 from 7 to 6
            move 10 from 1 to 3
            move 9 from 8 to 2
            move 1 from 7 to 1
            move 15 from 3 to 1
            move 1 from 8 to 9
            move 4 from 4 to 1
            move 17 from 1 to 3
            move 3 from 2 to 3
            move 3 from 6 to 8
            move 5 from 9 to 7
            move 11 from 1 to 8
            move 4 from 7 to 8
            move 6 from 2 to 5
            move 2 from 1 to 4
            move 4 from 6 to 8
            move 16 from 8 to 6
            move 2 from 6 to 1
            move 1 from 9 to 5
            move 1 from 7 to 5
            move 2 from 5 to 6
            move 5 from 6 to 3
            move 2 from 8 to 5
            move 1 from 2 to 1
            move 10 from 6 to 3
            move 6 from 5 to 9
            move 2 from 1 to 2
            move 2 from 4 to 2
            move 1 from 2 to 4
            move 5 from 9 to 2
            move 1 from 4 to 3
            move 1 from 9 to 7
            move 1 from 6 to 1
            move 1 from 1 to 7
            move 2 from 7 to 5
            move 7 from 2 to 5
            move 6 from 5 to 1
            move 1 from 2 to 3
            move 1 from 4 to 1
            move 2 from 8 to 9
            move 8 from 1 to 3
            move 2 from 5 to 3
            move 29 from 3 to 9
            move 5 from 3 to 8
            move 6 from 8 to 5
            move 1 from 6 to 5
            move 6 from 3 to 2
            move 2 from 2 to 4
            move 1 from 1 to 7
            move 18 from 9 to 6
            move 2 from 2 to 9
            move 2 from 2 to 8
            move 13 from 6 to 8
            move 1 from 7 to 4
            move 3 from 5 to 6
            move 1 from 5 to 7
            move 1 from 7 to 4
            move 14 from 9 to 3
            move 3 from 4 to 5
            move 1 from 9 to 7
            move 14 from 3 to 2
            move 1 from 7 to 3
            move 4 from 2 to 5
            move 16 from 8 to 6
            move 11 from 6 to 9
            move 13 from 6 to 4
            move 5 from 5 to 2
            move 12 from 2 to 4
            move 19 from 4 to 3
            move 7 from 4 to 5
            move 14 from 5 to 2
            move 2 from 3 to 6
            move 3 from 9 to 5
            move 2 from 6 to 2
            move 1 from 5 to 2
            move 3 from 5 to 4
            move 3 from 4 to 1
            move 7 from 9 to 6
            move 4 from 6 to 1
            move 1 from 1 to 8
            move 3 from 6 to 9
            move 1 from 8 to 7
            move 1 from 9 to 6
            move 4 from 1 to 2
            move 1 from 7 to 2
            move 2 from 9 to 8
            move 10 from 2 to 9
            move 2 from 2 to 9
            move 11 from 3 to 7
            move 1 from 8 to 9
            move 2 from 3 to 7
            move 1 from 1 to 7
            move 10 from 2 to 4
            move 3 from 4 to 1
            move 4 from 1 to 8
            move 1 from 6 to 5
            move 6 from 7 to 9
            move 3 from 9 to 1
            move 1 from 5 to 1
            move 4 from 4 to 2
            move 5 from 2 to 1
            move 1 from 2 to 7
            move 2 from 7 to 6
            move 1 from 2 to 1
            move 2 from 9 to 1
            move 3 from 4 to 7
            move 1 from 3 to 7
            move 2 from 8 to 3
            move 2 from 6 to 5
            move 2 from 5 to 8
            move 10 from 7 to 2
            move 6 from 9 to 1
            move 1 from 7 to 3
            move 2 from 8 to 9
            move 7 from 3 to 7
            move 7 from 3 to 9
            move 1 from 8 to 9
            move 6 from 2 to 8
            move 13 from 9 to 1
            move 6 from 9 to 8
            move 2 from 2 to 7
            move 3 from 7 to 1
            move 1 from 8 to 1
            move 1 from 1 to 6
            move 16 from 1 to 4
            move 2 from 7 to 5
            move 12 from 4 to 9
            move 4 from 8 to 6
            move 2 from 5 to 1
            move 8 from 8 to 4
            move 2 from 4 to 5
            move 1 from 8 to 6
            move 4 from 6 to 8
            move 19 from 1 to 9
            move 3 from 8 to 5
            move 1 from 6 to 9
            move 2 from 2 to 1
            move 10 from 4 to 9
            move 1 from 1 to 2
            move 2 from 1 to 5
            move 4 from 7 to 9
            move 1 from 8 to 2
            move 1 from 2 to 6
            move 7 from 5 to 4
            move 11 from 9 to 8
            move 1 from 4 to 3
            move 10 from 8 to 1
            move 1 from 2 to 3
            move 29 from 9 to 3
            move 2 from 6 to 5
            move 1 from 5 to 3
            move 5 from 9 to 3
            move 1 from 8 to 9
            move 1 from 9 to 3
            move 6 from 4 to 6
            move 1 from 5 to 1
            move 1 from 6 to 3
            move 2 from 1 to 5
            move 1 from 9 to 5
            move 37 from 3 to 2
            move 3 from 6 to 2
            move 1 from 6 to 2
            move 1 from 6 to 4
            move 3 from 1 to 3
            move 2 from 1 to 6
            move 35 from 2 to 1
            move 1 from 6 to 8
            move 5 from 1 to 8
            move 7 from 1 to 6
            move 5 from 3 to 7
            move 1 from 8 to 7
            move 3 from 7 to 5
            move 4 from 2 to 9
            move 1 from 2 to 1
            move 1 from 4 to 3
            move 3 from 7 to 1
            move 1 from 3 to 6
            move 1 from 1 to 9
            move 5 from 9 to 2
            move 18 from 1 to 3
            move 6 from 1 to 8
            move 6 from 3 to 7
            move 4 from 8 to 6
            move 4 from 6 to 7
            move 9 from 7 to 8
            move 3 from 2 to 7
            move 4 from 6 to 1
            move 3 from 5 to 3
            move 3 from 2 to 5
            move 3 from 6 to 1
            move 4 from 7 to 4
            move 6 from 5 to 9
            move 3 from 1 to 9
            move 1 from 6 to 1
            move 15 from 8 to 2
            move 1 from 8 to 5
            move 3 from 4 to 8
            move 1 from 5 to 1
            move 1 from 6 to 5
            move 11 from 3 to 9
            move 12 from 2 to 3
            move 3 from 8 to 1
            move 15 from 1 to 2
            move 8 from 9 to 4
            move 8 from 4 to 9
            move 4 from 2 to 5
            move 1 from 4 to 6
            move 1 from 2 to 8
            move 1 from 6 to 7
            move 4 from 3 to 1
            move 1 from 8 to 5
            move 5 from 3 to 9
            move 14 from 9 to 2
            move 1 from 7 to 4
            move 4 from 1 to 3
            move 1 from 4 to 7
            move 8 from 3 to 7
            move 8 from 7 to 5
            move 1 from 7 to 9
            move 3 from 3 to 2
            move 7 from 9 to 8
            move 1 from 9 to 5
            move 2 from 8 to 5
            move 7 from 5 to 4
            move 4 from 9 to 2
            move 6 from 4 to 3
            move 18 from 2 to 5
            move 1 from 4 to 7
            move 15 from 5 to 4
            move 1 from 4 to 6
            move 2 from 2 to 7
            move 3 from 8 to 5
            move 1 from 7 to 3
            move 8 from 2 to 6
            move 4 from 2 to 3
            move 1 from 7 to 5
            move 3 from 4 to 6
            move 5 from 6 to 9
            move 8 from 5 to 6
            move 2 from 4 to 3
            move 7 from 4 to 2
            move 2 from 8 to 5
            move 7 from 5 to 6
            move 3 from 5 to 8
            move 1 from 8 to 9
            move 13 from 3 to 8
            move 2 from 2 to 7
            move 9 from 8 to 9
            move 6 from 8 to 5
            move 5 from 5 to 2
            move 2 from 7 to 8
            move 9 from 2 to 5
            move 1 from 7 to 5
            move 1 from 5 to 7
            move 21 from 6 to 2
            move 1 from 7 to 8
            move 3 from 8 to 9
            move 1 from 4 to 2
            move 23 from 2 to 7
            move 8 from 9 to 8
            move 20 from 7 to 4
            move 3 from 7 to 2
            move 1 from 2 to 7
            move 1 from 6 to 7
            move 3 from 5 to 4
            move 8 from 5 to 9
            move 2 from 7 to 1
            move 1 from 8 to 7
            move 4 from 2 to 4
            move 2 from 8 to 7
            move 2 from 8 to 2
            move 1 from 7 to 6
            move 3 from 9 to 7
            move 2 from 2 to 7
            move 5 from 7 to 1
            move 8 from 9 to 6
            move 15 from 4 to 3
            move 4 from 4 to 7
            move 6 from 1 to 4
            move 11 from 3 to 4
            move 8 from 6 to 1
            move 24 from 4 to 7
            move 6 from 1 to 8
            move 27 from 7 to 3
            move 2 from 7 to 8
            move 5 from 8 to 3
            move 4 from 8 to 4
            move 1 from 8 to 6
            move 1 from 6 to 9
            move 1 from 6 to 5
            move 2 from 4 to 2
            move 1 from 8 to 1
            move 1 from 5 to 2
            move 4 from 1 to 6
            move 1 from 7 to 5
            move 1 from 5 to 8
            move 1 from 8 to 7
            move 1 from 7 to 8
            move 1 from 8 to 1
            move 1 from 2 to 3
            move 2 from 4 to 8
            move 7 from 9 to 6
            move 2 from 8 to 1
            move 3 from 3 to 8
            move 3 from 1 to 8
            move 2 from 2 to 3
            move 1 from 4 to 1
            move 1 from 1 to 8
            move 5 from 8 to 3
            move 8 from 6 to 2
            move 1 from 9 to 4
            move 2 from 4 to 8
            move 2 from 8 to 3
            move 2 from 6 to 2
            move 33 from 3 to 2
            move 2 from 8 to 7
            move 1 from 6 to 1
            move 1 from 1 to 7
            move 2 from 3 to 8
            move 2 from 8 to 4
            move 1 from 4 to 8
            move 2 from 7 to 2
            move 2 from 3 to 7
            move 12 from 2 to 1
            move 1 from 8 to 4
            move 1 from 4 to 8
            move 1 from 4 to 3
            move 1 from 8 to 2
            move 3 from 7 to 2
            move 37 from 2 to 7
            move 1 from 1 to 7
            move 12 from 7 to 1
            move 13 from 1 to 7
            move 1 from 3 to 4
            move 35 from 7 to 6
            move 1 from 4 to 5
            move 3 from 7 to 4
            move 1 from 5 to 7
            move 2 from 3 to 4
            move 23 from 6 to 9
            move 3 from 1 to 5
            move 3 from 3 to 7
            move 1 from 3 to 6
            move 2 from 5 to 3
            move 23 from 9 to 8
            move 2 from 4 to 9
            move 16 from 8 to 2
            move 2 from 7 to 3
            move 1 from 5 to 8
            move 3 from 7 to 6
            move 1 from 9 to 8
            move 3 from 8 to 1
            move 1 from 9 to 1
            move 11 from 6 to 5
            move 2 from 4 to 1
            move 4 from 8 to 6
            move 16 from 2 to 3
            move 9 from 1 to 9
            move 1 from 8 to 4
            move 3 from 9 to 3
            move 1 from 1 to 4
            move 1 from 9 to 4
            move 7 from 5 to 2
            move 6 from 2 to 5
            move 1 from 8 to 6
            move 22 from 3 to 7
            move 8 from 5 to 8
            move 4 from 4 to 9
            move 2 from 1 to 8
            move 16 from 7 to 2
            move 1 from 3 to 5
            move 14 from 2 to 7
            move 2 from 2 to 4
            move 6 from 9 to 3""";
}



