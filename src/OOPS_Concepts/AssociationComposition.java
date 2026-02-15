package OOPS_Concepts;

/**
 * Question 5: Association, Aggregation, and Composition
 */
class Processor {
    private String type;

    Processor(String t) {
        this.type = t;
    }

    public String toString() {
        return "Processor: " + type;
    }
}

class Monitor {
    private String brand;

    Monitor(String b) {
        this.brand = b;
    }

    public String toString() {
        return "Monitor: " + brand;
    }
}

class Computer {
    // Composition (Computer HAS-A Processor, lifetime is tied)
    private final Processor cpu;

    // Aggregation (Computer HAS-A Monitor, lifetime is independent)
    private Monitor monitor;

    Computer(String proc) {
        this.cpu = new Processor(proc);
    }

    void setMonitor(Monitor m) {
        this.monitor = m;
    }

    void showSpec() {
        System.out.println("Computer with " + cpu + (monitor != null ? " and " + monitor : ""));
    }
}

public class AssociationComposition {
    public static void main(String[] args) {
        Computer myPc = new Computer("Intel i9");
        Monitor dell = new Monitor("Dell 4K");

        myPc.setMonitor(dell);
        myPc.showSpec();
    }
}
