public class Grade {

        //grade private class
    private String subject;
    private float score;
    //parameter constructor
    public Grade(String subject, float score) {
        this.subject = subject;
        this.score = score;
    }
    //getter setter method
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public static char getLetterGrade(double score){
        if (score > 100 || score < 0){
            return 'E';
        } else if (score >= 70){
            return 'A';
        } else if (score >= 60){
            return 'B';
        } else if (score >= 50){
            return 'C';
        } else if (score >= 40){
            return 'D';
        } else {
            return 'F';
        }
    }
}
