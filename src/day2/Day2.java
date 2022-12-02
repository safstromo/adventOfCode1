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

        myScore = 0;

        myScore = part2(strategyGuide, myScore);
        System.out.println("Part 2 Score: " + myScore);

    }

    private static int part1(List<String> strategyGuide, int myScore) {
        String me;
        String opponent;
        for (String round : strategyGuide) {

            opponent = String.valueOf(round.charAt(0));
            me = String.valueOf(round.charAt(round.length() - 1));

            myScore = getScoreForChoice(myScore, me);


            myScore = geRoundScore(myScore, me, opponent);

        }
        return myScore;
    }

    private static int part2(List<String> strategyGuide, int myScore) {

        String me;
        String opponent;
        for (String round : strategyGuide) {

            opponent = String.valueOf(round.charAt(0));
            me = String.valueOf(round.charAt(round.length() - 1));

            if (me.contains("Z")) {
                me = win(opponent);
            } else if (me.contains("Y")) {
                me = draw(opponent);
            } else if (me.contains("X")) {
                me = lose(opponent);

            }
            myScore = getScoreForChoice(myScore, me);
            myScore = geRoundScore(myScore, me, opponent);
        }

        return myScore;
    }

    private static int getScoreForChoice(int myScore, String me) {
        if (me.contains(rock))
            myScore++;
        else if (me.contains(paper))
            myScore = myScore + 2;
        else if (me.contains(scissor))
            myScore = myScore + 3;
        return myScore;
    }

    private static int geRoundScore(int myScore, String me, String opponent) {
        if (winWithPaper(me, opponent))
            myScore = myScore + 6;
        else if (drawWithRock(me, opponent))
            myScore = myScore + 3;
        else if (winWithScissor(me, opponent))
            myScore = myScore + 6;
        else if (drawWithPaper(me, opponent))
            myScore = myScore + 3;
        else if (winWithRock(me, opponent))
            myScore = myScore + 6;
        else if (drawWithScissor(me, opponent))
            myScore = myScore + 3;
        return myScore;
    }

    private static String lose(String opponent) {
        String me;
        if (opponent.equals(opponentPaper))
            me = rock;
        else if (opponent.equals(opponentRock))
            me = scissor;
        else me = paper;
        return me;
    }

    private static String draw(String opponent) {
        String me;
        if (opponent.equals(opponentPaper))
            me = paper;
        else if (opponent.equals(opponentRock))
            me = rock;
        else
            me = scissor;
        return me;
    }

    private static String win(String opponent) {
        String me;
        if (opponent.equals(opponentPaper))
            me = scissor;
        else if (opponent.equals(opponentRock))
            me = paper;
        else
            me = rock;
        return me;
    }


    private static boolean drawWithScissor(String me, String opponent) {
        return opponent.contains(opponentScissor) && me.contains(scissor);
    }

    private static boolean winWithRock(String me, String opponent) {
        return opponent.contains(opponentScissor) && me.contains(rock);
    }

    private static boolean drawWithPaper(String me, String opponent) {
        return opponent.contains(opponentPaper) && me.contains(paper);
    }

    private static boolean winWithScissor(String me, String opponent) {
        return opponent.contains(opponentPaper) && me.contains(scissor);
    }

    private static boolean drawWithRock(String me, String opponent) {
        return opponent.contains(opponentRock) && me.contains(rock);
    }

    private static boolean winWithPaper(String me, String opponent) {
        return opponent.contains(opponentRock) && me.contains(paper);
    }
}
