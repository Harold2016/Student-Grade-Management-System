import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager manager = new GradeManager();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Show Average");
            System.out.println("4. Save & Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("ID: ");
                    String id = scanner.nextLine();
                    manager.addStudent(new Student(name, id));
                }

                else if (choice == 2) {
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();
                    Student s = manager.findStudent(id);
                    if (s != null) {
                        System.out.print("Grade: ");
                        double grade = scanner.nextDouble();
                        s.addGrade(grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                }

                else if (choice == 3) {
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();
                    Student s = manager.findStudent(id);
                    if (s != null) {
                        System.out.println("Average: " + s.calculateAverage());
                    } else {
                        System.out.println("Student not found.");
                    }
                }

                else if (choice == 4) {
                    manager.saveToFile("students.txt");
                    System.out.println("Saved. Exiting...");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
