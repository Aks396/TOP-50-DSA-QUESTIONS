package OOPS_Concepts;

/**
 * Question 4: Encapsulation Implementation
 */
class User {
    private String name;
    private int age;

    // Getter and Setter (Points of control)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0)
            this.age = age;
        else
            System.out.println("Invalid age!");
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        User u = new User();
        u.setName("John Doe");
        u.setAge(25);
        System.out.println("User: " + u.getName() + " (" + u.getAge() + ")");
    }
}
