# Senior Interview Answers: Design Patterns & SOLID

### 16. Explain the SOLID principles.
- **S (Single Responsibility)**: A class should have only one reason to change.
- **O (Open/Closed)**: Software entities should be open for extension but closed for modification.
- **L (Liskov Substitution)**: Derived classes must be substitutable for their base classes without breaking functionality.
- **I (Interface Segregation)**: Clients should not be forced to depend on methods they do not use (prefer small, specific interfaces).
- **D (Dependency Inversion)**: Depend on abstractions, not concretions. High-level modules should not depend on low-level modules.

### 17. Factory vs Abstract Factory.
- **Factory**: Creates objects of a single family (e.g., `ShapeFactory` returns `Circle` or `Square`).
- **Abstract Factory**: A "Factory of Factories". Creates families of related objects (e.g., `GUIFactory` returns both `MacButton` and `MacCheckbox`).

### 18. When to use Prototype pattern?
- Use it when creating a new object is **more expensive** than cloning an existing one (e.g., deep cloning a complex object with many fields from a database).

### 19. Explain the Proxy Pattern and Spring AOP.
- **Proxy**: Provides a placeholder for another object to control access to it (e.g., Lazy loading, Logging, Security).
- **Spring AOP**: Uses **JDK Dynamic Proxies** (for interfaces) or **CGLIB** (for classes) to intercept method calls and add cross-cutting concerns (logging, transactions).

### 20. What is the Strategy pattern?
- Defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from the clients that use it (e.g., different Payment strategies like CreditCard, PayPal).

### 21. Observer Pattern.
- Defines a one-to-many dependency so that when one object changes state, all its dependents (observers) are notified (e.g., Event listeners in UI, Kafka consumers).

### 22. Decorator Pattern and Java I/O.
- Attaches additional responsibilities to an object dynamically.
- **Java I/O**: `new BufferedReader(new FileReader("file.txt"))` wraps a basic reader with buffering functionality without modifying the original class.

### 23. State vs Strategy Pattern.
- **Strategy**: The client usually knows which strategy to use; used to change the "logic" of an operation.
- **State**: The transition between states is often handled within the state objects themselves; used to change "behavior" based on internal state changes.

### 24. Composition vs Aggregation.
- **Composition**: "Death relationship" - If the parent is destroyed, child is destroyed (e.g., Room in a House).
- **Aggregation**: "Independent relationship" - Child can exist without the parent (e.g., Student in a Teacher's list).

### 25. Thread-safe Singleton (Double-Checked Locking).
```java
public class Singleton {
    private static volatile Singleton instance;
    public static Singleton getInstance() {
        if (instance == null) { // 1st check
            synchronized (Singleton.class) {
                if (instance == null) { // 2nd check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```
*Note: `volatile` is crucial here to prevent instruction reordering.*

### 26-30 Quick Hits:
26. **Dependency Injection**: Decoupling the creation of a dependency from its usage. Spring manages the lifecycle and "injects" beans.
27. **Builder Pattern**: Best for objects with many parameters, some optional. Improves readability and prevents "Constructor Overloading Hell".
28. **Adapter Pattern**: Allows incompatible interfaces to work together (e.g., wrapping a legacy 3rd party API to fit your modern interface).
29. **Command Pattern**: Encapsulates a request as an object, allowing you to parameterize clients with different requests (e.g., Undo/Redo operations).
30. **Flyweight Pattern**: Minimizes memory usage by sharing as much data as possible with similar objects (e.g., `Integer.valueOf(-128 to 127)` cache).
