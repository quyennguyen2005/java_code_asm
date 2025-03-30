import java.util.*;

class Student implements Comparable<Student> {
    private int studentId;
    private String name;
    private double marks;
    private String rank;

 private String assignRank() {
        if (marks < 0 || marks > 10) return "Invalid";
        else if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
    public String getRank() { return rank; }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.marks, this.marks); // Max-Heap based on marks
    }

    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Marks: " + marks + ", Rank: " + rank;
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();
    private PriorityQueue<Student> studentHeap = new PriorityQueue<>();

    // Add Student
    public void addStudent(int id, String name, double marks) {
        Student student = new Student(id, name, marks);
        students.add(student);
        studentHeap.add(student);
    }

    // Display All Students Sorted by Marks
    public void displayStudents() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("\nStudent List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Search Student by ID (Using Linear Search)
    public void searchStudent(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                System.out.println("Student Found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Delete Student by ID
    public void deleteStudent(int id) {
        students.removeIf(student -> student.getStudentId() == id);
        studentHeap.removeIf(student -> student.getStudentId() == id);
        System.out.println("Student with ID " + id + " removed.");
    }

    // Display Top-Ranked Student
    public void displayTopStudent() {
        if (!studentHeap.isEmpty()) {
            System.out.println("\nTop-Ranked Student: " + studentHeap.peek());
        } else {
            System.out.println("No students available.");
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Display Top-Ranked Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();
                    manager.addStudent(id, name, marks);
                    break;
                case 2:
                    manager.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchStudent(searchId);
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 5:
                    manager.displayTopStudent();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
