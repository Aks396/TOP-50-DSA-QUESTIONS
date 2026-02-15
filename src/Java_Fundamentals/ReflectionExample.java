package Java_Fundamentals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Question 5: Java Reflection API Demo
 */
class PrivateTarget {
    private String secret = "Reflection Secret";

    private void displaySecret() {
        System.out.println("Displaying: " + secret);
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        PrivateTarget obj = new PrivateTarget();
        Class<?> cls = obj.getClass();

        // 1. Accessing private field
        Field field = cls.getDeclaredField("secret");
        field.setAccessible(true);
        System.out.println("Accessing private field: " + field.get(obj));

        // 2. Modifying private field
        field.set(obj, "Modified Secret");
        System.out.println("Updated secret: " + field.get(obj));

        // 3. Invoking private method
        Method method = cls.getDeclaredMethod("displaySecret");
        method.setAccessible(true);
        method.invoke(obj);
    }
}
