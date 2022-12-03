package day3;

import tools.fileReader;

import java.io.File;
import java.util.ArrayList;

import java.util.List;

public class Day3 {
    static File file = new File("src/day3/problemData.txt");
    static File file2 = new File("src/day3/test.txt");

    public static void main(String[] args) {
        List<String> rucksacks = fileReader.inputFileToList(file);
        List<Character> duplicate = new ArrayList<>();
        List<String> compartment1 = new ArrayList<>();
        List<String> compartment2 = new ArrayList<>();
        List<String> test = fileReader.inputFileToList(file2);
        part1(rucksacks, duplicate, compartment1, compartment2);












    }

    private static void part1(List<String> rucksacks, List<Character> duplicate, List<String> compartment1, List<String> compartment2) {
        splitBackPackToList(rucksacks, compartment1, compartment2);
        findDuplicates(duplicate, compartment1, compartment2);
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

            System.out.println(sum);
        }
    }
}
