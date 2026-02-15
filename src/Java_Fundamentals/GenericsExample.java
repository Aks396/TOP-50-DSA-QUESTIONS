package Java_Fundamentals;

import java.util.ArrayList;
import java.util.List;

/**
 * Question 2: Java Generics (Bounded Wildcards)
 */
class Box<T> {
    private T item;

    public void set(T t) {
        this.item = t;
    }

    public T get() {
        return item;
    }
}

public class GenericsExample {
    // Upper Bounded Wildcard (<? extends T>)
    public static double sum(List<? extends Number> list) {
        double s = 0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void main(String[] args) {
        Box<String> strBox = new Box<String>();
        strBox.set("Hello Generics");
        System.out.println("Box content: " + strBox.get());

        List<Integer> ints = new ArrayList<Integer>();
        ints.add(10);
        ints.add(20);
        System.out.println("Sum of list: " + sum(ints));
    }
}
