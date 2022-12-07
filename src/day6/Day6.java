package day6;

import tools.FileReader;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day6 {


    public static void main(String[] args) {


        List<String> ao = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/day6/ProblemData.txt"))) {
            ao = reader.lines().toList();
            System.out.println(ao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        part1(ao.get(0));

        part2(ao.get(0));


    }

    private static void part2(String aoc) {
        Set<Character> uniqueChars2 = new HashSet<>();
        int count = 0;
        for (int i = 0; i < aoc.length(); i++) {

            for (int j = 0; j < aoc.length(); j++) {


                if (endOfString(aoc, i, j))
                    break;

                addFourTeenCharsToSet(aoc, uniqueChars2, i);


            }
            if (sucsessPart2(uniqueChars2, count)) break;
            count++;
            uniqueChars2.clear();

        }
    }

    private static boolean sucsessPart2(Set<Character> uniqueChars2, int count) {
        if (uniqueChars2.size() == 14) {
            System.out.println("Part 2: " + (count + 14));
            System.out.println(uniqueChars2);
            return true;
        }
        return false;
    }

    private static boolean endOfString(String aoc, int i, int j) {
        return j == aoc.length() - 1 || i == aoc.length() - 1;
    }

    private static void addFourTeenCharsToSet(String aoc, Set<Character> uniqueChars2, int i) {
        uniqueChars2.add(aoc.charAt(i));
        uniqueChars2.add(aoc.charAt(i + 1));
        uniqueChars2.add(aoc.charAt(i + 2));
        uniqueChars2.add(aoc.charAt(i + 3));
        uniqueChars2.add(aoc.charAt(i + 4));
        uniqueChars2.add(aoc.charAt(i + 5));
        uniqueChars2.add(aoc.charAt(i + 6));
        uniqueChars2.add(aoc.charAt(i + 7));
        uniqueChars2.add(aoc.charAt(i + 8));
        uniqueChars2.add(aoc.charAt(i + 9));
        uniqueChars2.add(aoc.charAt(i + 10));
        uniqueChars2.add(aoc.charAt(i + 11));
        uniqueChars2.add(aoc.charAt(i + 12));
        uniqueChars2.add(aoc.charAt(i + 13));
    }


    private static void part1(String aoc) {
        Set<Character> uniqueChars = new HashSet<>();
        int count = 0;
        for (int i = 0; i < aoc.length(); i++) {

            for (int j = 0; j < aoc.length(); j++) {


                if (endOfString(aoc, j))
                    break;

                addFourCharsToSet(aoc, uniqueChars, i);


            }
            if (success(uniqueChars, count)) break;

            count++;
            uniqueChars.clear();

        }
    }

    private static boolean success(Set<Character> uniqueChars, int count) {
        if (uniqueChars.size() == 4) {
            System.out.println("Part 1: " + (count + 4));
            System.out.println(uniqueChars);
            return true;
        }
        return false;
    }

    private static void addFourCharsToSet(String aoc, Set<Character> uniqueChars, int i) {
        uniqueChars.add(aoc.charAt(i));
        uniqueChars.add(aoc.charAt(i + 1));
        uniqueChars.add(aoc.charAt(i + 2));
        uniqueChars.add(aoc.charAt(i + 3));
    }

    private static boolean endOfString(String aoc, int j) {
        return j == aoc.length() - 1;
    }

}
