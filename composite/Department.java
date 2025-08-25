package composite;
import java.util.List;

public class Department implements Organization {
    private String name;
    private List<Organization> entities;

    public Department(String name) {
        this.name = name;
        this.entities = new java.util.ArrayList<>();
    }

    public void add(Organization unit) {
        entities.add(unit);
    }

    public void remove(Organization unit) {
        entities.remove(unit);
    }

    public double getSalary() {
        return entities.stream().mapToDouble(Organization::getSalary).sum();
    }

    public void printXML() {
        System.out.println("[department name: " + name + "]");
        for (Organization unit : entities) {
            unit.printXML();
        }
    }
}
