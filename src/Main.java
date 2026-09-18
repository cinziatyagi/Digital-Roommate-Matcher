import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_PATH = "data/students.txt";

    public static void main(String[] args) {
        DataManager dataManager = new DataManager(FILE_PATH);
        ArrayList<Student> students = dataManager.loadStudents();

        System.out.println("==========================================");
        System.out.println("       DIGITAL ROOMMATE MATCHER");
        System.out.println("==========================================");

        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> registerStudent(students, dataManager);
                case 2 -> viewAllStudents(students);
                case 3 -> searchStudent(students);
                case 4 -> updateStudent(students, dataManager);
                case 5 -> deleteStudent(students, dataManager);
                case 6 -> findMatches(students);
                case 7 -> viewStudentDetails(students);
                case 8 -> {
                    System.out.println("\nThank you for using Digital Roommate Matcher!");
                    running = false;
                }
                default -> System.out.println("\n[!] Invalid choice. Please enter a number from 1 to 8.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n--------------- MAIN MENU ----------------");
        System.out.println("1. Register Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Profile");
        System.out.println("5. Delete Profile");
        System.out.println("6. Find Roommate Matches");
        System.out.println("7. View Student Details");
        System.out.println("8. Exit");
        System.out.println("------------------------------------------");
    }

    private static void registerStudent(ArrayList<Student> students,
                                        DataManager dataManager) {

        System.out.println("\n========== REGISTER STUDENT ==========");

        int id = readPositiveInt("Enter student ID: ");

        if (findStudentById(students, id) != null) {
            System.out.println("[!] Student ID already exists.");
            return;
        }

        String name = readNonEmpty("Enter name: ");
        String sleepSchedule = readChoice(
                "Sleep schedule (Early/Regular/Late): ",
                "Early", "Regular", "Late");

        String studySchedule = readChoice(
                "Study schedule (Morning/Afternoon/Evening/Night): ",
                "Morning", "Afternoon", "Evening", "Night");

        String cleanliness = readChoice(
                "Cleanliness level (Low/Medium/High): ",
                "Low", "Medium", "High");

        String noisePreference = readChoice(
                "Noise preference (Quiet/Moderate/Lively): ",
                "Quiet", "Moderate", "Lively");

        String acPreference = readChoice(
                "AC preference (Yes/No): ",
                "Yes", "No");

        String socialPreference = readChoice(
                "Social preference (Private/Moderate/Social): ",
                "Private", "Moderate", "Social");

        String foodPreference = readChoice(
                "Food preference (Vegetarian/Non-Vegetarian/No Preference): ",
                "Vegetarian", "Non-Vegetarian", "No Preference");

        String roomPreference = readChoice(
                "Room preference (Single/Double/Triple): ",
                "Single", "Double", "Triple");

        String hobbies = readNonEmpty(
                "Enter hobbies (comma-separated): ");

        Student student = new Student(
                id,
                name,
                sleepSchedule,
                studySchedule,
                cleanliness,
                noisePreference,
                acPreference,
                socialPreference,
                foodPreference,
                roomPreference,
                hobbies
        );

        students.add(student);
        dataManager.saveStudents(students);

        System.out.println("\n[+] Student registered successfully.");
    }

    private static void viewAllStudents(ArrayList<Student> students) {
        System.out.println("\n========== ALL STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No student profiles available.");
            return;
        }

        for (Student student : students) {
            System.out.println("----------------------------------");
            System.out.println("ID   : " + student.getStudentId());
            System.out.println("Name : " + student.getName());
        }

        System.out.println("----------------------------------");
        System.out.println("Total students: " + students.size());
    }

    private static void searchStudent(ArrayList<Student> students) {
        System.out.println("\n========== SEARCH STUDENT ==========");

        String keyword = readNonEmpty("Enter student ID or name: ");

        boolean found = false;

        for (Student student : students) {
            if (String.valueOf(student.getStudentId()).equalsIgnoreCase(keyword)
                    || student.getName().toLowerCase().contains(keyword.toLowerCase())) {

                student.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("[!] No matching student found.");
        }
    }

    private static void updateStudent(ArrayList<Student> students,
                                      DataManager dataManager) {

        System.out.println("\n========== UPDATE PROFILE ==========");

        int id = readPositiveInt("Enter student ID to update: ");
        Student student = findStudentById(students, id);

        if (student == null) {
            System.out.println("[!] Student not found.");
            return;
        }

        System.out.println("Current profile:");
        student.display();

        System.out.println("\nEnter new details:");

        String name = readNonEmpty("Name: ");

        String sleepSchedule = readChoice(
                "Sleep schedule (Early/Regular/Late): ",
                "Early", "Regular", "Late");

        String studySchedule = readChoice(
                "Study schedule (Morning/Afternoon/Evening/Night): ",
                "Morning", "Afternoon", "Evening", "Night");

        String cleanliness = readChoice(
                "Cleanliness level (Low/Medium/High): ",
                "Low", "Medium", "High");

        String noisePreference = readChoice(
                "Noise preference (Quiet/Moderate/Lively): ",
                "Quiet", "Moderate", "Lively");

        String acPreference = readChoice(
                "AC preference (Yes/No): ",
                "Yes", "No");

        String socialPreference = readChoice(
                "Social preference (Private/Moderate/Social): ",
                "Private", "Moderate", "Social");

        String foodPreference = readChoice(
                "Food preference (Vegetarian/Non-Vegetarian/No Preference): ",
                "Vegetarian", "Non-Vegetarian", "No Preference");

        String roomPreference = readChoice(
                "Room preference (Single/Double/Triple): ",
                "Single", "Double", "Triple");

        String hobbies = readNonEmpty(
                "Hobbies (comma-separated): ");

        student.updateProfile(
                name,
                sleepSchedule,
                studySchedule,
                cleanliness,
                noisePreference,
                acPreference,
                socialPreference,
                foodPreference,
                roomPreference,
                hobbies
        );

        dataManager.saveStudents(students);

        System.out.println("\n[+] Profile updated successfully.");
    }

    private static void deleteStudent(ArrayList<Student> students,
                                      DataManager dataManager) {

        System.out.println("\n========== DELETE PROFILE ==========");

        int id = readPositiveInt("Enter student ID to delete: ");
        Student student = findStudentById(students, id);

        if (student == null) {
            System.out.println("[!] Student not found.");
            return;
        }

        System.out.println("Student found: " + student.getName());

        String confirmation = readChoice(
                "Are you sure? (Yes/No): ",
                "Yes", "No");

        if (confirmation.equalsIgnoreCase("Yes")) {
            students.remove(student);
            dataManager.saveStudents(students);
            System.out.println("[+] Profile deleted successfully.");
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    private static void findMatches(ArrayList<Student> students) {
        System.out.println("\n========== FIND ROOMMATE MATCHES ==========");

        if (students.size() < 2) {
            System.out.println("[!] At least two student profiles are required.");
            return;
        }

        int id = readPositiveInt("Enter student ID: ");
        Student student = findStudentById(students, id);

        if (student == null) {
            System.out.println("[!] Student not found.");
            return;
        }

        RoommateMatcher matcher = new RoommateMatcher();
        List<MatchResult> results = matcher.findMatches(student, students);

        if (results.isEmpty()) {
            System.out.println("No roommate matches available.");
            return;
        }

        System.out.println("\nTOP ROOMMATE MATCHES");
        System.out.println("------------------------------------------");

        int rank = 1;

        for (MatchResult result : results) {
            System.out.println(
                    rank + ". "
                    + result.getStudent().getName()
                    + " (ID: " + result.getStudent().getStudentId() + ")"
                    + " - " + result.getScore() + "%"
                    + " - " + result.getCategory()
            );
            rank++;
        }
    }

    private static void viewStudentDetails(ArrayList<Student> students) {
        System.out.println("\n========== STUDENT DETAILS ==========");

        int id = readPositiveInt("Enter student ID: ");
        Student student = findStudentById(students, id);

        if (student == null) {
            System.out.println("[!] Student not found.");
            return;
        }

        student.display();
    }

    private static Student findStudentById(ArrayList<Student> students, int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }

        return null;
    }

    private static int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("[!] Please enter a positive number.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("[!] Please enter a valid number.");
            }
        }
    }

    private static String readNonEmpty(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty() && !input.contains("|")) {
                return input;
            }

            System.out.println("[!] Input cannot be empty or contain '|'.");
        }
    }

    private static String readChoice(String message, String... choices) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            for (String choice : choices) {
                if (choice.equalsIgnoreCase(input)) {
                    return choice;
                }
            }

            System.out.print("[!] Invalid choice. Please enter: ");

            for (int i = 0; i < choices.length; i++) {
                System.out.print(choices[i]);

                if (i < choices.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
        }
    }
}
