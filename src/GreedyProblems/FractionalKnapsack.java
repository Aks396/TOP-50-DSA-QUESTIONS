package GreedyProblems;

import java.util.*;

/**
 * Question 2: Fractional Knapsack Problem
 */
public class FractionalKnapsack {
    static class Item {
        int v, w;

        Item(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static double getMaxValue(int[] v, int[] w, int cap) {
        Item[] items = new Item[v.length];
        for (int i = 0; i < v.length; i++)
            items[i] = new Item(v[i], w[i]);

        Arrays.sort(items, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double r1 = (double) a.v / a.w;
                double r2 = (double) b.v / b.w;
                return Double.compare(r2, r1);
            }
        });

        double total = 0;
        for (Item item : items) {
            if (cap >= item.w) {
                cap -= item.w;
                total += item.v;
            } else {
                total += item.v * ((double) cap / item.w);
                break;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] v = { 60, 100, 120 };
        int[] w = { 10, 20, 30 };
        System.out.println("Max fractional value: " + getMaxValue(v, w, 50)); // 240.0
    }
}
