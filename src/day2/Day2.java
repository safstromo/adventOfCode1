package day2;

import tools.fileReader;

import java.io.File;

import java.util.List;

public class Day2 {
    static File file = new File("src/day2/problemData.txt");


    static String opponentRock = "A", opponentPaper = "B", opponentScissor = "C";
    static String rock = "X", paper = "Y", scissor = "Z";

    public static void main(String[] args) {
        List<String> strategyGuide = fileReader.inputFileToList(file);
        System.out.println(strategyGuide);

        var myScore = 0;

        myScore = part1(strategyGuide, myScore);
        System.out.println("Part 1 Score: " + myScore);




    }

    private static int part1(List<String> strategyGuide, int myScore) {
        String me;
        String opponent;
        for (String round : strategyGuide) {

            opponent = String.valueOf(round.charAt(0));
            me = String.valueOf(round.charAt(round.length() - 1));

            if (me.contains(rock))
                myScore++;
            else if (me.contains(paper))
                myScore = myScore + 2;
            else if (me.contains(scissor))
                myScore = myScore + 3;


            if (opponent.contains(opponentRock) && me.contains(paper))
                myScore = myScore + 6;
            else if (opponent.contains(opponentRock) && me.contains(rock))
                myScore = myScore + 3;
            else if (opponent.contains(opponentPaper) && me.contains(scissor))
                myScore = myScore + 6;
            else if (opponent.contains(opponentPaper) && me.contains(paper))
                myScore = myScore + 3;
            else if (opponent.contains(opponentScissor) && me.contains(rock))
                myScore = myScore + 6;
            else if (opponent.contains(opponentScissor) && me.contains(scissor))
                myScore = myScore + 3;

        }
        return myScore;
    }
}
