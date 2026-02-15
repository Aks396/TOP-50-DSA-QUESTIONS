package OOPS_Concepts;

/**
 * Question 1: Inheritance Implementation
 */
class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy is weeping...");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Puppy p = new Puppy();
        p.eat(); // Inherited from Animal
        p.bark(); // Inherited from Dog
        p.weep(); // Own method
    }
}
