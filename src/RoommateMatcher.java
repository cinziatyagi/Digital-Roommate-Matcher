import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RoommateMatcher {

    public List<MatchResult> findMatches(Student target,
                                          ArrayList<Student> students) {

        List<MatchResult> results = new ArrayList<>();

        for (Student student : students) {

            if (student.getStudentId() == target.getStudentId()) {
                continue;
            }

            int score = 0;
            List<String> compatible = new ArrayList<>();
            List<String> differences = new ArrayList<>();

            int sleepScore = compare(
                    target.getSleepSchedule(),
                    student.getSleepSchedule(),
                    20,
                    "Sleep Schedule",
                    compatible,
                    differences);
            score += sleepScore;

            int studyScore = compare(
                    target.getStudySchedule(),
                    student.getStudySchedule(),
                    15,
                    "Study Schedule",
                    compatible,
                    differences);
            score += studyScore;

            int cleanlinessScore = compare(
                    target.getCleanliness(),
                    student.getCleanliness(),
                    15,
                    "Cleanliness",
                    compatible,
                    differences);
            score += cleanlinessScore;

            int noiseScore = compare(
                    target.getNoisePreference(),
                    student.getNoisePreference(),
                    15,
                    "Noise Preference",
                    compatible,
                    differences);
            score += noiseScore;

            int acScore = compare(
                    target.getAcPreference(),
                    student.getAcPreference(),
                    10,
                    "AC Preference",
                    compatible,
                    differences);
            score += acScore;

            int socialScore = compare(
                    target.getSocialPreference(),
                    student.getSocialPreference(),
                    10,
                    "Social Preference",
                    compatible,
                    differences);
            score += socialScore;

            int foodScore = compareFood(
                    target.getFoodPreference(),
                    student.getFoodPreference(),
                    5,
                    compatible,
                    differences);
            score += foodScore;

            int roomScore = compare(
                    target.getRoomPreference(),
                    student.getRoomPreference(),
                    5,
                    "Room Preference",
                    compatible,
                    differences);
            score += roomScore;

            int hobbyScore = compareHobbies(
                    target.getHobbies(),
                    student.getHobbies(),
                    compatible,
                    differences);
            score += hobbyScore;

            String compatibleAreas = compatible.isEmpty()
                    ? "None"
                    : String.join(", ", compatible);

            String differenceAreas = differences.isEmpty()
                    ? "None"
                    : String.join(", ", differences);

            results.add(new MatchResult(
                    student,
                    score,
                    compatibleAreas,
                    differenceAreas
            ));
        }

        results.sort(
                Comparator.comparingInt(MatchResult::getScore).reversed()
        );

        return results;
    }

    private int compare(String first, String second, int weight,
                        String category, List<String> compatible,
                        List<String> differences) {

        if (first.equalsIgnoreCase(second)) {
            compatible.add(category);
            return weight;
        }

        differences.add(category);
        return 0;
    }

    private int compareFood(String first, String second, int weight,
                            List<String> compatible,
                            List<String> differences) {

        if (first.equalsIgnoreCase(second)
                || first.equalsIgnoreCase("No Preference")
                || second.equalsIgnoreCase("No Preference")) {

            compatible.add("Food Preference");
            return weight;
        }

        differences.add("Food Preference");
        return 0;
    }

    private int compareHobbies(String first, String second,
                               List<String> compatible,
                               List<String> differences) {

        String[] firstHobbies = first.split(",");
        String[] secondHobbies = second.split(",");

        int commonHobbies = 0;

        for (String hobby1 : firstHobbies) {
            for (String hobby2 : secondHobbies) {

                if (hobby1.trim().equalsIgnoreCase(hobby2.trim())) {
                    commonHobbies++;
                    break;
                }
            }
        }

        if (commonHobbies >= 2) {
            compatible.add("Hobbies");
            return 5;
        } else if (commonHobbies == 1) {
            compatible.add("Hobbies");
            return 3;
        } else {
            differences.add("Hobbies");
            return 0;
        }
    }
}
