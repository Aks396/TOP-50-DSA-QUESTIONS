package OOPS_Concepts;

/**
 * Question 2: Polymorphism Implementation
 */
class Printer {
    // Compile-time Polymorphism (Overloading)
    void print(String s) {
        System.out.println("Printing string: " + s);
    }

    void print(int i) {
        System.out.println("Printing integer: " + i);
    }
}

class AdvancedPrinter extends Printer {
    // Run-time Polymorphism (Overriding)
    @Override
    void print(String s) {
        System.out.println("Advanced Printing: [ " + s + " ]");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Printer p = new AdvancedPrinter(); // Upcasting
        p.print("Hello"); // Calls AdvacedPrinter.print (Dynamic Binding)
        p.print(100); // Calls Printer.print (Static Binding)
    }
}
