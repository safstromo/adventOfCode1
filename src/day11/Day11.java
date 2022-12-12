package day11;

import java.util.ArrayList;
import java.util.List;

public class Day11 {
    static List<Integer> monkey0 = new ArrayList<>(List.of(53, 89, 62, 57, 74, 51, 83, 97));
    static List<Integer> monkey1 = new ArrayList<>(List.of(85, 94, 97, 92, 56));
    static List<Integer> monkey2 = new ArrayList<>(List.of(86, 82, 82));
    static List<Integer> monkey3 = new ArrayList<>(List.of(94, 68));
    static List<Integer> monkey4 = new ArrayList<>(List.of(83, 62, 74, 58, 96, 68, 85));
    static List<Integer> monkey5 = new ArrayList<>(List.of(50, 68, 95, 82));
    static List<Integer> monkey6 = new ArrayList<>(List.of(75));
    static List<Integer> monkey7 = new ArrayList<>(List.of(92, 52, 85, 89, 68, 82));
    static int monkey0Count = 0;
    static int monkey1Count = 0;
    static int monkey2Count = 0;
    static int monkey3Count = 0;
    static int monkey4Count = 0;
    static int monkey5Count = 0;
    static int monkey6Count = 0;
    static int monkey7Count = 0;
static List<Integer> monkeyCount = new ArrayList<>(List.of(0,0,0,0,0,0,0));

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {


            monkey0(monkey0);
            monkey1(monkey1);
            monkey2(monkey2);
            monkey3(monkey3);
            monkey4(monkey4);
            monkey5(monkey5);
            monkey6(monkey6);
            monkey7(monkey7);

        }
        System.out.println(monkey0Count);
        System.out.println(monkey1Count);
        System.out.println(monkey2Count);
        System.out.println(monkey3Count);
        System.out.println(monkey4Count);
        System.out.println(monkey5Count);
        System.out.println(monkey6Count);
        System.out.println(monkey7Count);
        System.out.println(monkey4Count* monkey6Count);


    }

    static void monkey7(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey7Count++;

            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item * item;
            item = item / 3;
            if (item % 2 == 0)
                monkey0.add(item);
            else
                monkey1.add(item);
        }
    }

    static void monkey6(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey6Count++;
            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item * 7;
            item = item / 3;
            if (item % 5 == 0)
                monkey7.add(item);
            else
                monkey0.add(item);
        }
    }

    static void monkey5(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey5Count++;
            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item + 8;
            item = item / 3;
            if (item % 7 == 0)
                monkey2.add(item);
            else
                monkey4.add(item);
        }
    }

    static void monkey4(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey4Count++;
            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item + 4;
            item = item / 3;
            if (item % 3 == 0)
                monkey3.add(item);
            else
                monkey6.add(item);
        }
    }

    static void monkey3(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey3Count++;
            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item + 5;
            item = item / 3;
            if (item % 17 == 0)
                monkey7.add(item);
            else
                monkey6.add(item);
        }
    }

    static void monkey2(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey2Count++;
            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item + 1;
            item = item / 3;
            if (item % 11 == 0)
                monkey3.add(item);
            else
                monkey4.add(item);
        }
    }

    static void monkey1(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey1Count++;
            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item + 2;
            item = item / 3;
            if (item % 19 == 0)
                monkey5.add(item);
            else
                monkey2.add(item);
        }
    }

    static void monkey0(List<Integer> list) {
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            monkey0Count++;
            int item = (int) list.get(0);
            list.remove(list.get(0));
            item = item * 3;
            item = item / 3;
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


