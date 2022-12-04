package day4;


import tools.FileReader;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day4 {
    static File file = new File("src/day4/problemData.txt");

    public static void main(String[] args) {
        List<String> assignmentPairs = FileReader.inputFileToList(file);
        System.out.println(assignmentPairs);

        List<Integer> nums = assignmentPairs.stream()
                .map(s -> s.split(",|-"))
                .flatMap(Stream::of)
                .map(Integer::parseInt)
                .toList();
        System.out.println(nums);

        findOverlappingPairs(nums);

    }

    public static void findOverlappingPairs(List<Integer> nums) {
        int overlapCount = 0;
        int doubleCount = 0;
        for (int i = 0; i < nums.size(); i += 4) {
            int firstStart = nums.get(i);
            int firstEnd = nums.get(i + 1);
            int secondStart = nums.get(i + 2);
            int secondEnd = nums.get(i + 3);

            if ((firstStart <= secondStart && firstEnd >= secondEnd) ||
                    (secondStart <= firstStart && secondEnd >= firstEnd)) {
                overlapCount++;
            }

            Set<Integer> firstNums = IntStream.range(firstStart, firstEnd + 1).boxed().collect(Collectors.toSet());
            if (IntStream.range(secondStart, secondEnd + 1).anyMatch(firstNums::contains)) {
                doubleCount++;
            }
        }

        System.out.println("Part 1: " + overlapCount);
        System.out.println("Part 2: " + doubleCount);


    }
}

