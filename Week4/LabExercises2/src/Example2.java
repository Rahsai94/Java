/*
    Using the following weightings and score calculate the final grade and print out the degree classification
    coursework          weighting       score
    ------------------|---------------|---------
    Quizzes             15%             63
    Presentation        15%             67
    Essay               30%             56
    practical           40%             71
 */

public class Example2 {
    public static void main(String[] args) {
        double[] weighting = {0.15, 0.15, 0.3, 0.4};
        double[] studentGrades = {63, 67, 56, 71};
        String title[] = {"Quizzes     ","Presentation","Essay       ","practical   "};

        double total_grade = 0;

        System.out.println("Using the following weightings and score calculate the final grade and print out the degree classification");
        System.out.println(" coursework          weighting       score\n------------------|---------------|---------");

        for(int i = 0; i < studentGrades.length; i++){
            System.out.println(" "+title[i]+"        "+weighting[i]*100+"%          "+studentGrades[i]);
            total_grade += studentGrades[i] * weighting[i];
        }

        System.out.println("--------------------------------------------");
        System.out.println("Average grade:  "+total_grade);
    }
}
