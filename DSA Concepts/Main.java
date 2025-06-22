import java.util.*;

class Student {
    int id, age;
    String name, department;

    Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    void display() {
        System.out.printf("ID: %d\nName: %s\nAge: %d\nDepartment: %s\n--------------\n", id, name, age, department);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1) Add Student  2) Remove Student  3) Display Students  4) Exit");
            switch (sc.nextInt()) {
                case 1 -> {
                    System.out.print("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age: "); int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Department: "); String dept = sc.nextLine();
                    students.add(new Student(id, name, age, dept));
                    System.out.println("Student added.");
                }
                case 2 -> {
                    System.out.print("Enter ID to remove: ");
                    int id = sc.nextInt();
                    students.removeIf(s -> s.id == id);
                    System.out.println("Student removed.");
                }
                case 3 -> {
                    if (students.isEmpty()) System.out.println("No students found.");
                    students.forEach(Student::display);
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
