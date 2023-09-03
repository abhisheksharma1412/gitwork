import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private int id;
    private Map<String, Integer> courses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new HashMap<>();
    }

    public void enroll(String courseName, int grade) {
        courses.put(courseName, grade);
    }

    public double calculateAverageGrade() {
        if (courses.isEmpty()) {
            return 0.0;
        }

        int total = 0;
        for (int grade : courses.values()) {
            total += grade;
        }
        return (double) total / courses.size();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Map<String, Integer> getCourses() {
        return courses;
    }
}

public class StudentManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static int nextStudentId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll Student in Course");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    enrollStudent(scanner);
                    break;
                case 3:
                    calculateAverageGrade(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        Student student = new Student(name, nextStudentId++);
        students.add(student);
        System.out.println("Student added with ID: " + student.getId());
    }

    private static void enrollStudent(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available to enroll.");
            return;
        }

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        System.out.print("Enter course name: ");
        String courseName = scanner.next();
        System.out.print("Enter grade: ");
        int grade = scanner.nextInt();

        student.enroll(courseName, grade);
        System.out.println("Enrolled " + student.getName() + " in " + courseName + " with grade " + grade);
    }

    private static void calculateAverageGrade(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available to calculate average grade.");
            return;
        }

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student with ID " + studentId + " not found.");
            return;
        }

        double averageGrade = student.calculateAverageGrade();
        System.out.println(student.getName() + "'s average grade is: " + averageGrade);
    }

    private static Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }
}
