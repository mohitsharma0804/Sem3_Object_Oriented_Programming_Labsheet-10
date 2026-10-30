import java.util.ArrayList;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class StudentArrayListMain {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        // Adding elements
        studentList.add(new Student("Aarav"));
        studentList.add(new Student("Ananya"));
        studentList.add(new Student("Rohan"));
        studentList.add(new Student("Priya"));

        System.out.println("=== Initial Student List ===");
        for (Student s : studentList) {
            s.display();
        }

        // Removing an element
        System.out.println("
Removing student at index 2 (Rohan)...");
        studentList.remove(2);

        System.out.println("
=== Updated Student List after Removal ===");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.print("[" + i + "] ");
            studentList.get(i).display();
        }
    }
}
