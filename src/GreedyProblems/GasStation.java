package GreedyProblems;

/**
 * Question 10: Gas Station Problem (Greedy)
 * Example: gas = [1,2,3,4,5], cost = [3,4,5,1,2] Output: 3
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, curr = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            if (curr < 0) {
                curr = 0;
                start = i + 1;
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };
        System.out.println("Start Index: " + canCompleteCircuit(gas, cost)); // 3
    }
}
