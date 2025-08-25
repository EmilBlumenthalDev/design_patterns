package composite;

public class Employee implements Organization {
    private String name;
    private double salary;

    public Employee(String name, Float salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void printXML() {
        System.out.println("[employee name: " + name + " - salary: " + salary + "]");
    }
}
