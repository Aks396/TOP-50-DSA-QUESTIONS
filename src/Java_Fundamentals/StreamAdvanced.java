package Java_Fundamentals;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Question 4: Advanced Java Stream Operations
 */
public class StreamAdvanced {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 50000),
                new Employee("Jane", "IT", 60000),
                new Employee("Bob", "HR", 40000),
                new Employee("Alice", "HR", 45000),
                new Employee("Charlie", "Sales", 55000));

        // 1. GroupingBy: Group employees by department
        Map<String, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept));
        System.out.println("By Dept: " + byDept.keySet());

        // 2. Average salary by department
        Map<String, Double> avgSalary = employees.stream()
                .collect(Collectors.groupingBy(e -> e.dept, Collectors.averagingDouble(e -> e.salary)));
        System.out.println("Avg Salary: " + avgSalary);

        // 3. PartitioningBy: Employees with salary > 50000
        Map<Boolean, List<Employee>> highPaid = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary > 50000));
        System.out.println("High Paid Count: " + highPaid.get(true).size());
    }

    static class Employee {
        String name, dept;
        double salary;

        Employee(String n, String d, double s) {
            name = n;
            dept = d;
            salary = s;
        }
    }
}
