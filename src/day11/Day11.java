package day11;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Day11 {

    static List<BigInteger> monkeyt0 = new ArrayList<>(List.of(new BigInteger("78"), new BigInteger("98")));
    static List<BigInteger> monkeyt1 = new ArrayList<>(List.of(new BigInteger("54"), new BigInteger("65"), new BigInteger("75"), new BigInteger("74")));
    static List<BigInteger> monkeyt2 = new ArrayList<>(List.of(new BigInteger("79"), new BigInteger("60"), new BigInteger("97")));
    static List<BigInteger> monkeyt3 = new ArrayList<>(List.of(new BigInteger("74")));


    static List<Double> monkey0 = new ArrayList<>(List.of(53.0, 89.0, 62.0, 57.0, 74.0, 51.0, 83.0, 97.0));
    static List<Double> monkey1 = new ArrayList<>(List.of(85.0, 94.0, 97.0, 92.0, 56.0));
    static List<Double> monkey2 = new ArrayList<>(List.of(86.0, 82.0, 82.0));
    static List<Double> monkey3 = new ArrayList<>(List.of(94.0, 68.0));
    static List<Double> monkey4 = new ArrayList<>(List.of(83.0, 62.0, 74.0, 58.0, 96.0, 68.0, 85.0));
    static List<Double> monkey5 = new ArrayList<>(List.of(50.0, 68.0, 95.0, 82.0));
    static List<Double> monkey6 = new ArrayList<>(List.of(75.0));
    static List<Double> monkey7 = new ArrayList<>(List.of(92.0, 52.0, 85.0, 89.0, 68.0, 82.0));
    static long monkey0Count = 0;
    static long monkey1Count = 0;
    static long monkey2Count = 0;
    static long monkey3Count = 0;
    static long monkey4Count = 0;
    static long monkey5Count = 0;
    static long monkey6Count = 0;
    static long monkey7Count = 0;
    static List<Integer> monkeyCount = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0));

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {

            monkeyt0(monkeyt0);
            monkeyt1(monkeyt1);
            monkeyt2(monkeyt2);
            monkeyt3(monkeyt3);
//            monkey0(monkey0);
//            monkey1(monkey1);
//            monkey2(monkey2);
//            monkey3(monkey3);
//            monkey4(monkey4);
//            monkey5(monkey5);
//            monkey6(monkey6);
//            monkey7(monkey7);

        }


        System.out.println(monkey0Count);
        System.out.println(monkey1Count);
        System.out.println(monkey2Count);
        System.out.println(monkey3Count);
//        System.out.println(monkey4Count);
//        System.out.println(monkey5Count);
//        System.out.println(monkey6Count);
//        System.out.println(monkey7Count);
//        System.out.println(monkey4Count*monkey6Count);

    }

    static void monkeyt0(List<BigInteger> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey0Count++;

            BigInteger item = list.get(0);
            list.remove(list.get(0));
            item = item.multiply(BigInteger.valueOf(19));

            if (item.remainder(BigInteger.valueOf(23)).equals(BigInteger.valueOf(0)))
                monkeyt2.add(item);
            else
                monkeyt3.add(item);
        }
    }

    static void monkeyt1(List<BigInteger> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey1Count++;

            BigInteger item = list.get(0);
            list.remove(list.get(0));
            item = item.add(BigInteger.valueOf(6));

            if (item.remainder(BigInteger.valueOf(19)).equals(BigInteger.valueOf(0)))
                monkeyt2.add(item);
            else
                monkeyt0.add(item);
        }
    }

    static void monkeyt2(List<BigInteger> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey2Count++;

            BigInteger item = list.get(0);
            list.remove(list.get(0));

            item = item.multiply(item);

            if (item.remainder(BigInteger.valueOf(13)).equals(BigInteger.valueOf(0)))
                monkeyt1.add(item);
            else
                monkeyt3.add(item);
        }
    }

    static void monkeyt3(List<BigInteger> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey3Count++;

            BigInteger item = list.get(0);
            list.remove(list.get(0));
            item = item.add(BigInteger.valueOf(3));

            if (item.remainder(BigInteger.valueOf(17)).equals(BigInteger.valueOf(0)))
                monkeyt0.add(item);
            else
                monkeyt1.add(item);
        }
    }


    static void monkey7(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey7Count++;

            double item = list.get(0);
            list.remove(list.get(0));
            item = item * item;
            if (item % 2 == 0)
                monkey0.add(item);
            else
                monkey1.add(item);
        }
    }

    static void monkey6(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey6Count++;
            double item = list.get(0);
            list.remove(list.get(0));
            item = item * 7;
            if (item % 5 == 0)
                monkey7.add(item);
            else
                monkey0.add(item);
        }
    }

    static void monkey5(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey5Count++;
            double item = list.get(0);
            list.remove(list.get(0));
            item = item + 8;

            if (item % 7 == 0)
                monkey2.add(item);
            else
                monkey4.add(item);
        }
    }

    static void monkey4(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey4Count++;
            double item = list.get(0);
            list.remove(list.get(0));
            item = item + 4;

            if (item % 3 == 0)
                monkey3.add(item);
            else
                monkey6.add(item);
        }
    }

    static void monkey3(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey3Count++;
            double item = list.get(0);
            list.remove(list.get(0));
            item = item + 5;

            if (item % 17 == 0)
                monkey7.add(item);
            else
                monkey6.add(item);
        }
    }

    static void monkey2(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey2Count++;
            double item = list.get(0);
            list.remove(list.get(0));
            item = item + 1;

            if (item % 11 == 0)
                monkey3.add(item);
            else
                monkey4.add(item);
        }
    }

    static void monkey1(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey1Count++;
            double item = list.get(0);
            list.remove(list.get(0));
            item = item + 2;

            if (item % 19 == 0)
                monkey5.add(item);
            else
                monkey2.add(item);
        }
    }

    static void monkey0(List<Double> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey0Count++;
            double item = list.get(0);
            list.remove(list.get(0));
            item = item * 3;

            if (item % 13 == 0)
                monkey1.add(item);
            else
                monkey5.add(item);
        }
    }


}


//    Monkey 0:
//    Starting items: 79, 98
//    Operation: new = old * 19
//    Test: divisible by 23
//    If true: throw to monkey 2
//    If false: throw to monkey 3
//
//    Monkey 1:
//    Starting items: 54, 65, 75, 74
//    Operation: new = old + 6
//    Test: divisible by 19
//    If true: throw to monkey 2
//    If false: throw to monkey 0
//
//    Monkey 2:
//    Starting items: 79, 60, 97
//    Operation: new = old * old
//    Test: divisible by 13
//    If true: throw to monkey 1
//    If false: throw to monkey 3
//
//    Monkey 3:
//    Starting items: 74
//    Operation: new = old + 3
//    Test: divisible by 17
//    If true: throw to monkey 0
//    If false: throw to monkey 1


