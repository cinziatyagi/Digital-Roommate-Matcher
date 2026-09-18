public class MatchResult {

    private Student student;
    private int score;
    private String compatibleAreas;
    private String differences;

    public MatchResult(Student student, int score,
                       String compatibleAreas, String differences) {
        this.student = student;
        this.score = score;
        this.compatibleAreas = compatibleAreas;
        this.differences = differences;
    }

    public Student getStudent() {
        return student;
    }

    public int getScore() {
        return score;
    }

    public String getCompatibleAreas() {
        return compatibleAreas;
    }

    public String getDifferences() {
        return differences;
    }

    public String getCategory() {
        if (score >= 90) {
            return "Excellent Compatibility";
        } else if (score >= 75) {
            return "High Compatibility";
        } else if (score >= 60) {
            return "Moderate Compatibility";
        } else {
            return "Low Compatibility";
        }
    }
}
