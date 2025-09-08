package strategy;

import java.util.Scanner;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Collections;
import java.util.List;

public class main {
    private static void generateRandomArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
    }

    public static void main(String[] args) {
        SortContext context = new SortContext();

        // create a map for the results of each algorithm
        Dictionary<String, Long> results = new Hashtable<>();

        int[] dataset1 = new int[30];
        int[] dataset2 = new int[10000];
        generateRandomArray(dataset1);
        generateRandomArray(dataset2);

        String[] algorithms = { "BubbleSort", "QuickSort", "StalinSort" };
        SortAlgo[] strategies = { new BubbleSort(), new QuickSort(), new StalinSort() };

        for (int i = 0; i < algorithms.length; i++) {
            context.setStrategy(strategies[i]);
            long start = System.nanoTime();
            context.sortArray(dataset1.clone());
            long end = System.nanoTime();
            results.put(algorithms[i] + " dataset1", end - start);
        }

        for (int i = 0; i < algorithms.length; i++) {
            context.setStrategy(strategies[i]);
            long start = System.nanoTime();
            context.sortArray(dataset2.clone());
            long end = System.nanoTime();
            results.put(algorithms[i] + " dataset2", end - start);
        }

        System.out.printf("%-20s %-15s %-15s%n", "Algorithm", "Dataset1 (ms)", "Dataset2 (ms)");
        System.out.println("----------------------------------------------------");
        for (String algorithm : algorithms) {
            System.out.printf("%-20s %-15.3f %-15.3f%n",
                algorithm,
                results.get(algorithm + " dataset1") / 1_000_000.0,
                results.get(algorithm + " dataset2") / 1_000_000.0);
        }
    }
}
