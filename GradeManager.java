import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Student> students;

    public GradeManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void loadFromFile(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Loaded: " + line);
        }
        scanner.close();
    }
    public boolean removeStudent(String id) {
        Student s = findStudent(id);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
    public Student findStudent(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public void saveToFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filename));
        for (Student s : students) {
            writer.println(s.toFileString());
        }
        writer.close();
    }
}
