package Java_Fundamentals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Question 1: Exception Handling (Checked, Unchecked, Custom)
 */
class CustomException extends Exception {
    public CustomException(String msg) {
        super(msg);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        // 1. Try-catch-finally
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Handled Unchecked: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }

        // 2. Try-with-resources (Automatic closing)
        try (BufferedReader br = new BufferedReader(new FileReader("dummy.txt"))) {
            System.out.println(br.readLine());
        } catch (IOException e) {
            System.out.println("Handled Checked (IOException): " + e.getMessage());
        }

        // 3. Throwing Custom Exception
        try {
            validate(15);
        } catch (CustomException e) {
            System.out.println("Caught Custom: " + e.getMessage());
        }
    }

    static void validate(int age) throws CustomException {
        if (age < 18)
            throw new CustomException("Minor exception!");
    }
}
