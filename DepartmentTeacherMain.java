import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Department {
    private int deptId;
    private String deptName;

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void displayDept() {
        System.out.println("Department [ID: " + deptId + ", Name: " + deptName + "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptId == that.deptId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId);
    }
}

class Teacher {
    private int teacherId;
    private String teacherName;

    public Teacher(int teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    public void displayTeacher() {
        System.out.println("  - Teacher [ID: " + teacherId + ", Name: " + teacherName + "]");
    }
}

public class DepartmentTeacherMain {
    private ArrayList<Department> departments = new ArrayList<>();
    private HashMap<Department, List<Teacher>> departmentTeacherMap = new HashMap<>();

    public void addDepartment(Department dept) {
        departments.add(dept);
        departmentTeacherMap.putIfAbsent(dept, new ArrayList<>());
    }

    public void addTeacherToDepartment(Department dept, Teacher teacher) {
        if (departmentTeacherMap.containsKey(dept)) {
            departmentTeacherMap.get(dept).add(teacher);
        } else {
            System.out.println("Department not found!");
        }
    }

    public void displayAll() {
        System.out.println("=== Departments and Assigned Teachers ===");
        for (Department dept : departments) {
            dept.displayDept();
            List<Teacher> teachers = departmentTeacherMap.get(dept);
            if (teachers == null || teachers.isEmpty()) {
                System.out.println("  (No teachers assigned yet)");
            } else {
                for (Teacher t : teachers) {
                    t.displayTeacher();
                }
            }
            System.out.println("----------------------------------------");
        }
    }

    public static void main(String[] args) {
        DepartmentTeacherMain system = new DepartmentTeacherMain();

        Department cs = new Department(1, "Computer Science");
        Department math = new Department(2, "Mathematics");

        system.addDepartment(cs);
        system.addDepartment(math);

        system.addTeacherToDepartment(cs, new Teacher(101, "Dr. Sharma"));
        system.addTeacherToDepartment(cs, new Teacher(102, "Prof. Gupta"));

        system.addTeacherToDepartment(math, new Teacher(201, "Dr. Rao"));

        system.displayAll();
    }
}
