import java.io.*;
import java.util.ArrayList;

public class DataManager {

    private String filePath;

    public DataManager(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(filePath);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                Student student = Student.fromFileString(line);

                if (student != null) {
                    students.add(student);
                }
            }

        } catch (IOException e) {
            System.out.println("[!] Error reading student data: "
                    + e.getMessage());
        }

        return students;
    }

    public void saveStudents(ArrayList<Student> students) {

        File file = new File(filePath);
        File parentDirectory = file.getParentFile();

        if (parentDirectory != null && !parentDirectory.exists()) {
            parentDirectory.mkdirs();
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(file))) {

            for (Student student : students) {
                writer.write(student.toFileString());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("[!] Error saving student data: "
                    + e.getMessage());
        }
    }
}
