public class Grade {

    // Grade private instance variables
    private String subject;
    private float score;

    // Parameter Constructor
    public Grade(String subject, float score) {
        this.subject = subject;
        this.score = score;
    }

    // Getter Setter Methods
    public String getSubject() {
        return subject;
    }
    public float getScore() {
        return score;
    }

    // Static Method for the get Grade
    public static char getLetterGrade(double score){
        if(score > 100 || score < 0){
            return 'E';
        }else if(score >= 70){
            return 'A';
        } else if(score >= 60){
            return 'B';
        }else if(score >= 50 ){
            return 'C';
        }else if(score >= 40){
            return 'D';
        }else {
            return 'F';
        }
    }


    @Override
    public String toString() {
        return "Grade{" +
                "subject='" + subject + '\'' +
                ", score=" + score +
                '}';
    }
}
