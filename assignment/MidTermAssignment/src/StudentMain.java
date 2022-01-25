import java.io.Console;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class StudentMain {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

//        Add All Student Data from PDF
        Student student = new Student("Bert Smith", "Computing", 21, 12345, true);
        student.grades.add(new Grade("programming",52));
        student.grades.add(new Grade("web dev",63));
        student.grades.add(new Grade("maths",76));
        student.grades.add(new Grade("algorithms",68));
        students.add(student);

        student = new Student("Olivia Green", "Computing", 19, 23464, true);
        student.grades.add(new Grade("programming",73));
        student.grades.add(new Grade("web dev",82));
        student.grades.add(new Grade("maths",72));
        student.grades.add(new Grade("algorithms",66));
        students.add(student);

        student = new Student("Eloise Jones", "Computing", 18, 34744, true);
        student.grades.add(new Grade("programming",65));
        student.grades.add(new Grade("web dev",63));
        student.grades.add(new Grade("maths",37));
        student.grades.add(new Grade("algorithms",40));
        students.add(student);

        student = new Student("Ben Bird", "Computing", 42, 34834, false);
        student.grades.add(new Grade("programming",55));
        student.grades.add(new Grade("web dev",29));
        student.grades.add(new Grade("maths",56));
        student.grades.add(new Grade("algorithms",38));
        students.add(student);

        student = new Student("Karen Brown", "Computing", 25, 45632, false);
        student.grades.add(new Grade("programming",62));
        student.grades.add(new Grade("web dev",51));
        student.grades.add(new Grade("maths",43));
        student.grades.add(new Grade("algorithms",43));
        students.add(student);


        /*
          Create a menu system in the Main class that allows for uses to interrogate the system. It should have the following options.
        • Print out a report of all students including lettered grades for each module score
        • Print the name of all students with a failed module
        • print out average grade for each student
        • Add a new student to the system taking in name, department, age, student
            number and a grade for each of the four modules.
        * */

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1. Report of All Students\n2. Failed Modules of Students\n3. Avarage Grades of Students\n4. Add new Student\n5. Quit");

            try {

                switch (scanner.nextInt()){
                    case 1:
                        System.out.println("****** Report of All Students ******");
                        for(Student s: students){
                            System.out.println("Name: "+ s.getName());
                            System.out.println("Username: "+ s.getUserName());
                            System.out.println("Age: "+ s.getAge());
                            System.out.println("Department: "+ s.getDepartment());
                            System.out.println("Student Number: "+s.getStudentNumber());
                            if(s.isFullTime())
                                System.out.println("Full Time: Yes");
                            else
                                System.out.println("Full Time: No");

                            System.out.println();
                        }
                        break;
                    case 2:

                        System.out.println("****** Failed Modules of Students ******");

                        for(Student s: students){
                            int count = 0;
                            System.out.println("Name of Student: "+s.getName());
                            for(Grade g: s.grades){
                                if(Grade.getLetterGrade(g.getScore()) == 'F'){
                                    System.out.println("Subject : " + g.getSubject());
                                    count++;
                                }
                            }

                            if (count == 0){
                                System.out.println("There is no Failed Modules ");
                            }
                            System.out.println();
                        }

                        break;
                    case 3:
                        System.out.println("****** Avarage Grades of Students ******");
                        for(Student s: students){
                            System.out.println("Name of Student: "+s.getName());
                            double total = 0;
                            for(Grade g: s.grades){
                                total += g.getScore();
                            }
                            System.out.println("Average Grade: "+(total/s.grades.size())+"\n");
                        }
                        break;
                    case 4:

                        Scanner input = new Scanner(System.in);
                        System.out.println("*** Enter the Student Details ***");

                        System.out.println("Enter Name: ");
                        String name = input.nextLine();


                        System.out.println("Enter Department: ");
                        String department = input.nextLine();

                        System.out.println("Enter Age: ");
                        int age = input.nextInt();

                        System.out.println("Enter Student Number: ");
                        int studentNumber = input.nextInt();

                        Student st = new Student(name,department, age, studentNumber, true);

                        System.out.println("--- Enter Grades ---");

                        System.out.println("Programming: ");
                        float programming = input.nextFloat();
                        st.grades.add(new Grade("programming", programming));

                        System.out.println("Web Developemnt: ");
                        float webDev = input.nextFloat();
                        st.grades.add(new Grade("web dev", webDev));

                        System.out.println("Math: ");
                        float math = input.nextFloat();
                        st.grades.add(new Grade("maths", math));

                        System.out.println("Algorithms: ");
                        float algo = input.nextFloat();
                        st.grades.add(new Grade("algorithms", algo));

                        students.add(st);
                        break;
                    case 5:
                        return ;
                    default:
                        System.out.println("Wrong Choice");
                        break;
                }

            }catch (InputMismatchException e){
                System.out.println("Wrong Input ");
                break;
            }

        }
    }



}
