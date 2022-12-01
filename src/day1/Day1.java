package day1;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day1 {

    static List<Integer> listOfElves = new ArrayList<>();

    public static void main(String[] args) {
        List<String> listOfNumbers = inputFileToList();

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

    static List<String> inputFileToList() {
        File file = new File("src/day1/problemData.txt");
        List<String> templist = new ArrayList<>();
        LineIterator lineIterator = null;
        try {
            lineIterator = FileUtils.lineIterator(file);
            while (lineIterator.hasNext()) {
                String line = lineIterator.next();
                templist.add(line);
            }
        } catch (IOException ignored) {
        } finally {
            LineIterator.closeQuietly(lineIterator);
        }
        return templist;
    }
}
