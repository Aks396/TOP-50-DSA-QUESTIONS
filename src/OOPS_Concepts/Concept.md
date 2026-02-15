# Concept: Object-Oriented Programming (OOPS)

OOPS is a programming paradigm based on the concept of "objects," which can contain data and code.

## 🧠 The 4 Pillars

1. **Encapsulation**: Wrapping data (`variables`) and code (`methods`) into a single unit. Use access modifiers (`private`, `protected`) to hide internal state.
2. **Inheritance**: A mechanism where one class acquires the properties and behaviors of a parent class. Supports code reusability.
3. **Polymorphism**: The ability of a message to be displayed in more than one form.
   - **Static (Compile-time)**: Method Overloading.
   - **Dynamic (Run-time)**: Method Overriding.
4. **Abstraction**: Hiding complex implementation details and showing only the essential features of an object. Implemented using Abstract classes and Interfaces.

## 🛠️ Design Principles (SOLID)
- **S**: Single Responsibility.
- **O**: Open/Closed (Open for extension, closed for modification).
- **L**: Liskov Substitution.
- **I**: Interface Segregation.
- **D**: Dependency Inversion.

## 📊 Key Differences: Abstract Class vs Interface
- **Abstract Class**: Can have constructors, instance variables, and non-abstract methods. Supports single inheritance.
- **Interface**: Primarily for contract definition. Since Java 8, can have `default` and `static` methods. Supports multiple inheritance.
