package composite;

public class main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Jaska", 50000f);
        Employee emp2 = new Employee("Petteri", 60000f);
        Department dept = new Department("Devops");
        dept.add(emp1);
        dept.add(emp2);

        System.out.println("Total Salary: " + dept.getSalary());
        dept.printXML();
    }
}