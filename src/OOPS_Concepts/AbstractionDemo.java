package OOPS_Concepts;

/**
 * Question 3: Abstraction Implementation
 */
interface Shape {
    void draw(); // Abstract by default

    default void msg() {
        System.out.println("Drawing a shape...");
    }
}

abstract class Polygon implements Shape {
    abstract int getSides();
}

class Square extends Polygon {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }

    @Override
    int getSides() {
        return 4;
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Shape s = new Square();
        s.msg();
        s.draw();

        Polygon p = (Polygon) s;
        System.out.println("Sides: " + p.getSides());
    }
}
