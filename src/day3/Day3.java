package day3;

import tools.FileReader;

import java.io.File;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {
    static File file = new File("src/day3/problemData.txt");


    public static void main(String[] args) {
        List<String> rucksacks = FileReader.inputFileToList(file);
        List<Character> duplicate = new ArrayList<>();
        List<String> compartment1 = new ArrayList<>();
        List<String> compartment2 = new ArrayList<>();
        List<Character> badges = new ArrayList<>();

        part1(rucksacks, duplicate, compartment1, compartment2);
        part2(rucksacks, badges);

    }

    private static void part2(List<String> rucksacks, List<Character> badges) {
        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();
        Set<Character> s3 = new HashSet<>();

        forEachElfGroupFindBadges(rucksacks, badges, s1, s2, s3);

        System.out.println("\nPart2");
        sumCharValues(badges);
    }

    private static void forEachElfGroupFindBadges(List<String> rucksacks, List<Character> badges, Set<Character> s1, Set<Character> s2, Set<Character> s3) {
        for (int k = 0; k < rucksacks.size(); k = k + 3) {
            findUniqueCharsInString(rucksacks, s1, s2, s3, k);
            findBadges(badges, s1, s2, s3);
            clearSets(s1, s2, s3);
        }
    }

    private static void clearSets(Set<Character> s1, Set<Character> s2, Set<Character> s3) {
        s1.clear();
        s2.clear();
        s3.clear();
    }

    private static void findBadges(List<Character> badges, Set<Character> s1, Set<Character> s2, Set<Character> s3) {
        for (char ch : s1) {
            if (s2.contains(ch) && s3.contains(ch))
                badges.add(ch);
        }
    }

    private static void findUniqueCharsInString(List<String> rucksacks, Set<Character> s1, Set<Character> s2, Set<Character> s3, int k) {
        for (int i = 0; i < rucksacks.get(k).length(); i++) {
            s1.add(rucksacks.get(k).charAt(i));
        }
        for (int i = 0; i < rucksacks.get(k + 1).length(); i++) {
            s2.add(rucksacks.get(k + 1).charAt(i));
        }
        for (int i = 0; i < rucksacks.get(k + 2).length(); i++) {
            s3.add(rucksacks.get(k + 2).charAt(i));
        }
    }


    private static void part1(List<String> rucksacks, List<Character> duplicate, List<String> compartment1, List<String> compartment2) {
        splitBackPackToList(rucksacks, compartment1, compartment2);
        findDuplicates(duplicate, compartment1, compartment2);
        System.out.println("Part1");
        sumCharValues(duplicate);
    }

    private static void findDuplicates(List<Character> duplicate, List<String> compartment1, List<String> compartment2) {
        for (int i = 0; i < compartment1.size(); i++) {
            String stringToTest = compartment1.get(i);
            char[] arrayToTest = stringToTest.toCharArray();

            for (char c : arrayToTest) {
                if (compartment2.get(i).contains(String.valueOf(c))) {
                    duplicate.add(c);
                    break;
                }
            }


        }
    }

    private static void splitBackPackToList(List<String> test2, List<String> compartment1, List<String> compartment2) {
        for (String s : test2) {
            compartment1.add(s.substring(0, s.length() / 2));
            compartment2.add(s.substring(s.length() / 2));
        }
    }

    private static void sumCharValues(List<Character> duplicate) {
        int sum = 0;
        for (char ch : duplicate) {
            if (ch >= 'a' && ch <= 'z')
                sum += 1 + ch - 'a';

            else if (ch >= 'A' && ch <= 'Z')
                sum += 27 + ch - 'A';

        }
        System.out.println("Sum of items is: " + sum);
    }
}
