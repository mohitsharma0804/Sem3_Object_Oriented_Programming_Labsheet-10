import java.util.HashMap;
import java.util.Map;

class Student {
    private int rollNo;
    private String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public void display() {
        System.out.println("Roll No: " + rollNo + " | Name: " + name);
    }
}

class StudentRegistry {
    private HashMap<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(int rollNo, String name) {
        Student s = new Student(rollNo, name);
        studentMap.put(rollNo, s);
        System.out.println("Added Roll No " + rollNo + " -> " + name);
    }

    public void removeStudent(int rollNo) {
        if (studentMap.containsKey(rollNo)) {
            Student removed = studentMap.remove(rollNo);
            System.out.println("Removed Roll No " + rollNo);
        } else {
            System.out.println("Roll No " + rollNo + " not found.");
        }
    }

    public void displayAllStudents() {
        System.out.println("
=== Registered Students in HashMap ===");
        if (studentMap.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.print("Key [" + entry.getKey() + "] -> ");
            entry.getValue().display();
        }
    }
}

public class StudentHashMapMain {
    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();

        registry.addStudent(101, "Karan");
        registry.addStudent(102, "Simran");
        registry.addStudent(103, "Manish");

        registry.displayAllStudents();

        System.out.println("
Removing Roll No 102...");
        registry.removeStudent(102);

        registry.displayAllStudents();
    }
}
