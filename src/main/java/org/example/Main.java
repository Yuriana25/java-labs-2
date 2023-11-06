package org.example;

import java.util.ArrayList;
import java.util.Random;

enum SortingType { BubbleSorter, ShellSorter, MergeSorter, QuickSorter }
public class Main {
    public static void main(String[] args) {
        for (int count: new int[]{10, 1000, 10000, 1000000}) {
            ArrayList<Integer> arrList = new ArrayList<>();
            fill(arrList, count);
            System.out.println("\n\nNumber of elements: " + count);
            print(arrList);
            for(SortingType type : SortingType.values()){
                Sorter sorter = getSorter(type);
                ArrayList<Integer> input = new ArrayList<>(arrList);
                measureSortingTime(input, sorter, type.toString());
            }
        }

    }
    private static void fill(ArrayList<Integer> arrayList, int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            arrayList.add(rand.nextInt(count));
        }
    }
    private static void print(ArrayList<Integer> arrayList){
        int count = Math.min(arrayList.size(), 50);
        for (int i = 0; i < count; i++) {
            System.out.print(arrayList.get(i));
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
    private static void measureSortingTime(ArrayList<Integer> arrayList, Sorter sorter, String sorterType){
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sortedList = sorter.sort(arrayList);
        long endTime = System.currentTimeMillis();
        System.out.printf("\n------- Sorting type: %12s | Time: %5d ms -------\n", sorterType, endTime - startTime);
        print(sortedList);
    }
    private static Sorter getSorter(SortingType type) {
        switch (type) {
            case BubbleSorter:
                return new BubbleSorting();
            case ShellSorter:
                return new ShellSorting();
            case MergeSorter:
                return new MergeSorting();
            case QuickSorter:
                return new QuickSorting();
            default:
                return null;
        }
    }
}