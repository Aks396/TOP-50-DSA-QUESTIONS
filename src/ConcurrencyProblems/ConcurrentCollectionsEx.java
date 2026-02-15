package ConcurrencyProblems;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;
import java.util.Map;

/**
 * Question 7: Concurrent Collections usage
 */
public class ConcurrentCollectionsEx {
    public static void main(String[] args) {
        // 1. ConcurrentHashMap: Thread-safe without full-table locking
        Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();
        map.put("A", 1);
        map.compute("A", (k, v) -> v + 1);
        System.out.println("ConcurrentMap value for A: " + map.get("A"));

        // 2. CopyOnWriteArrayList: Good for read-heavy operations
        List<String> list = new CopyOnWriteArrayList<String>();
        list.add("Item1");

        // Iterating is safe even if someone else modifies the list
        for (String s : list) {
            System.out.println("Reading: " + s);
            list.add("NewItem"); // This modification won't trigger ConcurrentModificationException
        }
        System.out.println("List size after iteration: " + list.size());
    }
}
