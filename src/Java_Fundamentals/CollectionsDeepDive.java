package Java_Fundamentals;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Question 3: Java Collections Framework Deep Dive
 */
public class CollectionsDeepDive {
    public static void main(String[] args) {
        // 1. Fail-Fast (ArrayList Iterator)
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");

        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String s = it.next();
                list.add("C"); // Modifying directly while iterating
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Caught Fail-Fast behavior!");
        }

        // 2. HashMap Internals Demo (Concepts only in code)
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Key", 100);
        System.out.println("Map Value: " + map.get("Key"));

        // 3. Tree Set (Natural Sorting)
        Set<Integer> set = new TreeSet<Integer>();
        set.add(10);
        set.add(5);
        set.add(20);
        System.out.println("Sorted Set: " + set);
    }
}
