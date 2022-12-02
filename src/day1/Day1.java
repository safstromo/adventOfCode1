package day1;

import tools.fileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day1 {

    static List<Integer> listOfElves = new ArrayList<>();
    static File file = new File("src/day1/problemData.txt");

    public static void main(String[] args) {
        List<String> listOfNumbers = fileReader.inputFileToList(file);

        addSumOfElfToList(listOfNumbers);
        System.out.println("The elf with most calories have " + Collections.max(listOfElves));
        System.out.println("The top three elves have " + addTopThree() + " calories");


    }

    private static int addTopThree() {
        listOfElves.sort(Comparator.reverseOrder());
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            temp = listOfElves.get(i) + temp;
        }
        return temp;
    }

    private static void addSumOfElfToList(List<String> listOfNumbers) {
        int tempNumber = 0;
        for (String listOfNumber : listOfNumbers) {
            if (!listOfNumber.equals(""))
                tempNumber = Integer.parseInt(listOfNumber) + tempNumber;
            else {
                listOfElves.add(tempNumber);
                tempNumber = 0;
            }
        }
    }

}
