import java.util.LinkedList;

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayPerson() {
        System.out.print("Name: " + name + " | Age: " + age);
    }
}

class Employee extends Person {
    private int empId;
    private double salary;

    public Employee(String name, int age, int empId, double salary) {
        super(name, age);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployee() {
        displayPerson();
        System.out.println(" | Emp ID: " + empId + " | Salary: $" + salary);
    }
}

class EmployeeManager {
    private LinkedList<Employee> employeeList = new LinkedList<>();

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
        System.out.println("Employee " + emp.name + " added successfully.");
    }

    public void displayAllEmployees() {
        System.out.println("
=== All Employee Records ===");
        if (employeeList.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }
        for (Employee emp : employeeList) {
            emp.displayEmployee();
        }
    }

    public void searchEmployeeByName(String name) {
        System.out.println("
Searching for Employee: " + name);
        boolean found = false;
        for (Employee emp : employeeList) {
            if (emp.name.equalsIgnoreCase(name)) {
                System.out.print("Record Found -> ");
                emp.displayEmployee();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employee found with name: " + name);
        }
    }
}

public class EmployeeLinkedListMain {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee("Vikram", 30, 101, 60000.0));
        manager.addEmployee(new Employee("Neha", 28, 102, 65000.0));
        manager.addEmployee(new Employee("Suresh", 35, 103, 72000.0));

        manager.displayAllEmployees();

        manager.searchEmployeeByName("Neha");
        manager.searchEmployeeByName("Rahul");
    }
}
