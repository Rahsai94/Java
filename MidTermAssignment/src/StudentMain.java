import java.util.ArrayList;

public class StudentMain {


    private static  ArrayList<Student> students = new ArrayList<Student>();

    public static void main(String[] args) {



//        Student student = new Student("Bert Smith", "Computing", 21, 12345, true);
//        student.grades.add(new Grade("programming",52));
//        student.grades.add(new Grade("web dev",63));
//        student.grades.add(new Grade("maths",76));
//        student.grades.add(new Grade("algorithms",68));
//
//        students.add(student);



        students.add(new Student("Bert Smith", "Computing", 21, 12345, true));
        students.get(0).grades.add(new Grade("programming",52));
        students.get(0).grades.add(new Grade("programming",52));
        students.get(0).grades.add(new Grade("web dev",63));
        students.get(0).grades.add(new Grade("maths",76));
        students.get(0).grades.add(new Grade("algorithms",68));

        System.out.println(students.get(0).toString());



    }

}
