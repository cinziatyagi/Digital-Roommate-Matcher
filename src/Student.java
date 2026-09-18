public class Student {

    private int studentId;
    private String name;
    private String sleepSchedule;
    private String studySchedule;
    private String cleanliness;
    private String noisePreference;
    private String acPreference;
    private String socialPreference;
    private String foodPreference;
    private String roomPreference;
    private String hobbies;

    public Student(int studentId, String name, String sleepSchedule,
                   String studySchedule, String cleanliness,
                   String noisePreference, String acPreference,
                   String socialPreference, String foodPreference,
                   String roomPreference, String hobbies) {

        this.studentId = studentId;
        this.name = name;
        this.sleepSchedule = sleepSchedule;
        this.studySchedule = studySchedule;
        this.cleanliness = cleanliness;
        this.noisePreference = noisePreference;
        this.acPreference = acPreference;
        this.socialPreference = socialPreference;
        this.foodPreference = foodPreference;
        this.roomPreference = roomPreference;
        this.hobbies = hobbies;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getSleepSchedule() {
        return sleepSchedule;
    }

    public String getStudySchedule() {
        return studySchedule;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public String getNoisePreference() {
        return noisePreference;
    }

    public String getAcPreference() {
        return acPreference;
    }

    public String getSocialPreference() {
        return socialPreference;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public String getRoomPreference() {
        return roomPreference;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void updateProfile(String name, String sleepSchedule,
                              String studySchedule, String cleanliness,
                              String noisePreference, String acPreference,
                              String socialPreference, String foodPreference,
                              String roomPreference, String hobbies) {

        this.name = name;
        this.sleepSchedule = sleepSchedule;
        this.studySchedule = studySchedule;
        this.cleanliness = cleanliness;
        this.noisePreference = noisePreference;
        this.acPreference = acPreference;
        this.socialPreference = socialPreference;
        this.foodPreference = foodPreference;
        this.roomPreference = roomPreference;
        this.hobbies = hobbies;
    }

    public String toFileString() {
        return studentId + "|" + name + "|" + sleepSchedule + "|"
                + studySchedule + "|" + cleanliness + "|"
                + noisePreference + "|" + acPreference + "|"
                + socialPreference + "|" + foodPreference + "|"
                + roomPreference + "|" + hobbies;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split("\\|", -1);

        if (parts.length != 11) {
            return null;
        }

        try {
            int id = Integer.parseInt(parts[0].trim());

            return new Student(
                    id,
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim(),
                    parts[4].trim(),
                    parts[5].trim(),
                    parts[6].trim(),
                    parts[7].trim(),
                    parts[8].trim(),
                    parts[9].trim(),
                    parts[10].trim()
            );
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void display() {
        System.out.println("\n------------------------------------------");
        System.out.println("Student ID       : " + studentId);
        System.out.println("Name             : " + name);
        System.out.println("Sleep Schedule   : " + sleepSchedule);
        System.out.println("Study Schedule   : " + studySchedule);
        System.out.println("Cleanliness      : " + cleanliness);
        System.out.println("Noise Preference : " + noisePreference);
        System.out.println("AC Preference    : " + acPreference);
        System.out.println("Social Preference: " + socialPreference);
        System.out.println("Food Preference  : " + foodPreference);
        System.out.println("Room Preference  : " + roomPreference);
        System.out.println("Hobbies          : " + hobbies);
        System.out.println("------------------------------------------");
    }
}
